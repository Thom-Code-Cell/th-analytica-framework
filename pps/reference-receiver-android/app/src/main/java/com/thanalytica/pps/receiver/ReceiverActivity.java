package com.thanalytica.pps.receiver;

import android.Manifest;
import android.bluetooth.*;
import android.bluetooth.le.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.*;
import android.view.View;
import android.widget.*;
import androidx.activity.ComponentActivity;
import androidx.camera.core.*;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.*;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import java.io.*;
import java.util.*;
import java.util.concurrent.Executor;

/** Foreground-only experiment; controls only this app, never other cameras. */
public final class ReceiverActivity extends ComponentActivity {
    private final PrivacyGate gate = new PrivacyGate();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ParcelUuid uuid = ParcelUuid.fromString(PrivacyGate.UUID);
    private TextView status, evidence;
    private PreviewView preview;
    private BluetoothLeScanner scanner;
    private ScanCallback callback;
    private ProcessCameraProvider provider;
    private VideoCapture<Recorder> video;
    private Recording recording;
    private Executor main;
    private final java.util.concurrent.ExecutorService qrExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
    private volatile long lastQrFrame;
    private long lastQrRestriction = Long.MIN_VALUE;
    private ImageAnalysis qrAnalysis;
    private boolean foreground, scanning, opening, cameraClosed = true, finalizing, failed;
    private long scanStarted, stopAt;
    private int generation;
    private File directory, lastVideo;
    private String message = "Gesperrt. Zuerst Empfang starten.";
    private final BroadcastReceiver bluetoothState = new BroadcastReceiver() {
        @Override public void onReceive(Context c, Intent i) {
            if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(i.getAction())
                    && i.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) != BluetoothAdapter.STATE_ON) {
                stopScan(); restrict("Bluetooth nicht verfügbar");
            }
        }
    };

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        main = ContextCompat.getMainExecutor(this);
        directory = new File(getFilesDir(), "tests");
        directory.mkdirs();
        // Restore newest completed clip for explicit viewing/export after recreation.
        File[] clips = directory.listFiles((d,n) -> n.endsWith(".mp4"));
        if (clips != null) for (File f : clips) if (lastVideo == null || f.lastModified() > lastVideo.lastModified()) lastVideo=f;
        LinearLayout root = new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(20,20,20,20);
        ScrollView scroll = new ScrollView(this); scroll.addView(root); setContentView(scroll);
        scroll.setOnApplyWindowInsetsListener((v,insets)->{ v.setPadding(insets.getSystemWindowInsetLeft(),insets.getSystemWindowInsetTop(),insets.getSystemWindowInsetRight(),insets.getSystemWindowInsetBottom()); return insets; });
        TextView title = new TextView(this); title.setText("PPS+ Empfangstest · 0.2"); title.setTextSize(24); root.addView(title);
        TextView note = new TextView(this);
        note.setText("Nur diese Test-App. BLE Draft v1 und lokale PPS-QR-Erkennung (0.1). QR-Scannen benötigt Kamerabilder; vor der Erkennung können Bilder aufgenommen werden. Nur cap=deny wird als Aufnahmesperre umgesetzt; keine Notruffunktion. Keine Wirkung auf fremde Geräte. Videos ohne Ton bleiben lokal. Keine KI-Analyse und kein automatischer Upload. Nur mit Zustimmung der aufgenommenen Personen testen.");
        root.addView(note);
        status = new TextView(this); status.setTextSize(18); root.addView(status);
        preview = new PreviewView(this); root.addView(preview, new LinearLayout.LayoutParams(-1,450));
        button(root,"1 · BLE-Empfang starten",this::startScan);
        button(root,"2 · Manuell freigeben + Vorschau",this::releaseCamera);
        button(root,"3 · Lokale Testaufnahme starten",this::startRecording);
        button(root,"Aufnahme stoppen / Kamera sperren",() -> restrict("Manuell gesperrt"));
        button(root,"Sperre simulieren (kein BLE-Nachweis)",() -> {
            log("simulation", ""); restrict("SIMULATION: kein Funknachweis");
        });
        button(root,"Letztes Testvideo ansehen",() -> shareVideo(false));
        button(root,"Letztes Testvideo ausdrücklich teilen",() -> shareVideo(true));
        button(root,"Lokales Protokoll teilen",this::shareLog);
        button(root,"Testdateien löschen",() -> {
            if (recording != null || finalizing) { message="Zuerst Aufnahme beenden."; render(); return; }
            new android.app.AlertDialog.Builder(this).setMessage("Alle lokalen Testvideos und das Protokoll löschen?")
                .setPositiveButton("Löschen",(d,w)->{
                    boolean ok=true; File[] files=directory.listFiles();
                    if(files!=null) for(File f:files) if(!f.delete()) ok=false;
                    lastVideo=null; message=ok?"Testdateien gelöscht.":"Nicht alle Dateien konnten gelöscht werden."; render();
                }).setNegativeButton("Abbrechen",null).show();
        });
        evidence = new TextView(this); root.addView(evidence);
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        if(Build.VERSION.SDK_INT>=33) registerReceiver(bluetoothState,filter,Context.RECEIVER_NOT_EXPORTED);
        else registerReceiver(bluetoothState,filter);
        render();
    }
    private void button(LinearLayout root,String label,Runnable action) {
        Button b=new Button(this); b.setText(label); b.setAllCaps(false); b.setOnClickListener(v->action.run()); root.addView(b);
    }
    private boolean permitted() {
        if(checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED) return false;
        if(Build.VERSION.SDK_INT>=31) return checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN)==PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT)==PackageManager.PERMISSION_GRANTED;
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED;
    }
    private BluetoothAdapter adapter() {
        BluetoothManager m=(BluetoothManager)getSystemService(BLUETOOTH_SERVICE); return m==null?null:m.getAdapter();
    }
    private void startScan() {
        if(scanning) return;
        if(!permitted()) {
            requestPermissions(Build.VERSION.SDK_INT>=31 ? new String[]{Manifest.permission.CAMERA,Manifest.permission.BLUETOOTH_SCAN,Manifest.permission.BLUETOOTH_CONNECT}
                : new String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION},10); return;
        }
        try {
            BluetoothAdapter a=adapter(); if(a==null || !a.isEnabled()) throw new IllegalStateException("Bluetooth einschalten");
            if(Build.VERSION.SDK_INT<=30) {
                android.location.LocationManager lm=(android.location.LocationManager)getSystemService(LOCATION_SERVICE);
                if(!lm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER) && !lm.isProviderEnabled(android.location.LocationManager.NETWORK_PROVIDER))
                    throw new IllegalStateException("Android benötigt den Standortdienst für BLE-Scans; die App liest keine Position.");
            }
            scanner=a.getBluetoothLeScanner(); if(scanner==null) throw new IllegalStateException("Kein BLE-Scanner");
            ScanCallback current = new ScanCallback() {
                @Override public void onScanResult(int t,ScanResult r) { main.execute(()->receive(this,r)); }
                @Override public void onBatchScanResults(List<ScanResult> results) { for(ScanResult r:results) onScanResult(0,r); }
                @Override public void onScanFailed(int e) { main.execute(()->{
                    if(callback!=this) return; stopScan(); failed=true; restrict("Scan fehlgeschlagen: "+e);
                }); }
            };
            callback=current; scanning=true; scanStarted=SystemClock.elapsedRealtime();
            ScanFilter filter=new ScanFilter.Builder().setServiceData(uuid,new byte[0]).build();
            scanner.startScan(Collections.singletonList(filter),new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).setReportDelay(0).build(),current);
            message="Empfang angefordert. Nach 5 Sekunden ohne Einschränkung manuell freigeben. Kein Signal ist keine Einwilligung.";
            log("scan_requested",""); handler.post(watchdog); render();
        } catch(SecurityException e) { stopScan(); failed=true; restrict("Bluetooth-Berechtigung entzogen"); }
        catch(RuntimeException e) { stopScan(); failed=true; restrict("Empfang nicht verfügbar: "+e.getMessage()); }
    }
    private void receive(ScanCallback source,ScanResult r) {
        if(!foreground || !scanning || source!=callback || r.getScanRecord()==null) return;
        byte[] p=r.getScanRecord().getServiceData(uuid); if(p==null) return;
        PrivacyGate.Packet verdict=gate.receive(p,SystemClock.elapsedRealtime());
        if(verdict!=PrivacyGate.Packet.NO_RESTRICTION) {
            if(recording!=null || !cameraClosed || opening || !gate.blocked()) log("pps_received",verdict.name());
            restrict(verdict==PrivacyGate.Packet.INVALID?"Unbekanntes/ungültiges PPS: vorsorgliche Sperre":"PPS-Einschränkung erkannt");
        }
    }
    private final Runnable watchdog=new Runnable() { public void run() {
        if(!scanning) return;
        try { if(!permitted() || adapter()==null || !adapter().isEnabled()) { stopScan(); restrict("Berechtigung oder Bluetooth verloren"); return; } }
        catch(RuntimeException e) { stopScan(); restrict("Empfang nicht prüfbar"); return; }
        handler.postDelayed(this,500);
    }};
    private void stopScan() {
        scanning=false; handler.removeCallbacks(watchdog);
        ScanCallback old=callback; callback=null;
        try { if(scanner!=null && old!=null) scanner.stopScan(old); } catch(SecurityException ignored) { /* Permission revoked: camera stays locked. */ } catch(RuntimeException ignored) {}
        scanner=null;
    }
    private void releaseCamera() {
        if(!foreground || finalizing || recording!=null || opening || !cameraClosed) { message="Kamera/Aufnahme noch aktiv oder wird beendet."; render(); return; }
        if((lastQrRestriction != Long.MIN_VALUE && SystemClock.elapsedRealtime()-lastQrRestriction < 5000) || !permitted() || !gate.release(SystemClock.elapsedRealtime(),scanStarted,scanning)) {
            message="Gesperrt: Empfang starten und mindestens 5 Sekunden ohne restriktives/ungültiges PPS warten."; render(); return;
        }
        failed=false; opening=true; int epoch=++generation;
        message="Kamera wird geöffnet. Nur für einen vereinbarten Test freigegeben."; log("manual_release",""); render();
        var future=ProcessCameraProvider.getInstance(this);
        future.addListener(()->{
            try {
                provider=future.get();
                if(epoch!=generation || gate.blocked() || !foreground || !scanning) { opening=false; render(); return; }
                Preview p=new Preview.Builder().build(); p.setSurfaceProvider(preview.getSurfaceProvider());
                Recorder recorder=new Recorder.Builder().setQualitySelector(QualitySelector.from(Quality.SD,FallbackStrategy.higherQualityOrLowerThan(Quality.SD))).build();
                video=VideoCapture.withOutput(recorder);
                qrAnalysis=new ImageAnalysis.Builder().setTargetResolution(new android.util.Size(1280,720))
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST).build();
                qrAnalysis.setAnalyzer(qrExecutor, frame -> analyzeQr(frame,epoch));
                cameraClosed=false;
                androidx.camera.core.Camera camera=provider.bindToLifecycle(this,CameraSelector.DEFAULT_BACK_CAMERA,p,video,qrAnalysis);
                log("qr_scan_started","local;pps-policy-0.1");
                opening=false;
                camera.getCameraInfo().getCameraState().observe(this,state->{
                    if(epoch!=generation) return;
                    cameraClosed=state.getType()==CameraState.Type.CLOSED;
                    if(state.getError()!=null) { failed=true; restrict("Kamerafehler: "+state.getError().getCode()); }
                    render();
                });
                message="Vorschau aktiv. Aufnahme startet nur per Taste."; render();
            } catch(Exception e) { opening=false; cameraClosed=true; failed=true; restrict("Kamera mit QR-Analyse konnte nicht gestartet werden; Gerätekombination eventuell nicht unterstützt"); }
        },main);
    }
    private void analyzeQr(ImageProxy frame,int epoch) {
        try {
            long now=SystemClock.elapsedRealtime();
            if(now-lastQrFrame<200) return;
            lastQrFrame=now;
            ImageProxy.PlaneProxy plane=frame.getPlanes()[0];
            java.nio.ByteBuffer buffer=plane.getBuffer().duplicate();
            int width=frame.getWidth(), height=frame.getHeight(), offset=buffer.position();
            byte[] y=new byte[width*height];
            for(int row=0;row<height;row++) for(int col=0;col<width;col++)
                y[row*width+col]=buffer.get(offset+row*plane.getRowStride()+col*plane.getPixelStride());
            com.google.zxing.PlanarYUVLuminanceSource source=new com.google.zxing.PlanarYUVLuminanceSource(y,width,height,0,0,width,height,false);
            com.google.zxing.BinaryBitmap bitmap=new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(source));
            Map<com.google.zxing.DecodeHintType,Object> hints=new EnumMap<>(com.google.zxing.DecodeHintType.class);
            hints.put(com.google.zxing.DecodeHintType.TRY_HARDER,Boolean.TRUE);
            com.google.zxing.Result[] results=new com.google.zxing.multi.qrcode.QRCodeMultiReader().decodeMultiple(bitmap,hints);
            for(com.google.zxing.Result result:results) {
                QrPolicy.Verdict verdict=QrPolicy.parse(result.getText());
                if(verdict==QrPolicy.Verdict.RESTRICT || verdict==QrPolicy.Verdict.INVALID) {
                    main.execute(()->{
                        if(epoch!=generation || !foreground || gate.blocked()) return;
                        lastQrRestriction=SystemClock.elapsedRealtime();
                        log("qr_policy_received",verdict.name());
                        restrict(verdict==QrPolicy.Verdict.RESTRICT?"PPS-QR: Aufnahmeverbot erkannt":"PPS-QR unbekannt/ungültig: vorsorgliche Sperre");
                    });
                    break;
                }
            }
        } catch(com.google.zxing.NotFoundException ignored) { /* No readable QR in this frame. */ }
        catch(RuntimeException e) { main.execute(()->{ if(epoch==generation && foreground && !gate.blocked()) {
            failed=true; log("qr_scan_error",e.getClass().getSimpleName()); restrict("QR-Analyse fehlgeschlagen");
        }}); }
        finally { frame.close(); }
    }
    private void startRecording() {
        if(gate.blocked() || !foreground || !scanning || !permitted() || opening || cameraClosed || video==null || recording!=null || finalizing) {
            message="Aufnahme nicht bereit. Empfang und Vorschau prüfen."; render(); return;
        }
        File file=new File(directory,"test-"+System.currentTimeMillis()+".mp4");
        try {
            FileOutputOptions output=new FileOutputOptions.Builder(file).setFileSizeLimit(50L*1024*1024).build();
            recording=video.getOutput().prepareRecording(this,output).start(main,event->{
                if(event instanceof VideoRecordEvent.Start) {
                    log("record_started",file.getName());
                    if(gate.blocked() || !foreground || !scanning) restrict("Start nach Sperre: Aufnahme wird beendet");
                    else { message="TESTAUFNAHME LÄUFT · ohne Ton · lokal"; render(); }
                } else if(event instanceof VideoRecordEvent.Finalize) {
                    VideoRecordEvent.Finalize done=(VideoRecordEvent.Finalize)event;
                    recording=null; finalizing=false;
                    if(done.hasError()) { failed=true; message="Aufnahme beendet mit Fehler "+done.getError()+". Datei prüfen."; }
                    else message="Aufnahmefinalisierung bestätigt. Datei zur Kontrolle verfügbar.";
                    lastVideo=file;
                    log("record_finalized","error="+done.getError()+";bytes="+file.length()+";stop_ms="+(stopAt==0?-1:SystemClock.elapsedRealtime()-stopAt));
                    gate.lock(); if(provider!=null) provider.unbindAll(); preview.setVisibility(View.INVISIBLE); render();
                    long size=file.length();
                    handler.postDelayed(()->{ long after=file.length(); log("file_size_check","before="+size+";after="+after);
                        if(after!=size) { failed=true; message="Datei hat sich nach Finalisierung verändert: Test fehlgeschlagen."; }
                        render();
                    },2000);
                }
            });
            stopAt=0; message="Aufnahme wird gestartet …"; render();
        } catch(RuntimeException e) { failed=true; restrict("Aufnahmestart fehlgeschlagen"); }
    }
    private void restrict(String why) {
        gate.lock(); message=why;
        if(qrAnalysis!=null) qrAnalysis.clearAnalyzer();
        preview.setVisibility(View.INVISIBLE);
        if(recording!=null && !finalizing) {
            finalizing=true; stopAt=SystemClock.elapsedRealtime(); log("stop_requested",why);
            try { recording.stop(); } catch(RuntimeException e) { failed=true; message="Aufnahmestopp fehlgeschlagen; keine Bestätigung."; }
            handler.postDelayed(()->{ if(finalizing) { failed=true; message="Keine Finalisierungsbestätigung nach 5 Sekunden."; render(); } },5000);
        }
        if(provider!=null) provider.unbindAll();
        render();
    }
    private void render() {
        if(status==null) return;
        boolean confirmed=gate.blocked() && cameraClosed && !opening && recording==null && !finalizing && !failed;
        String state=failed?"FEHLER · keine Schutzbestätigung": finalizing?"STOPP ANGEFORDERT · Bestätigung ausstehend":confirmed?"EIGENE KAMERA GESCHLOSSEN · Aufnahme inaktiv":gate.blocked()?"SPERRE ANGEFORDERT · Kamera schliesst":"TEST FREIGEGEBEN · nur diese App";
        status.setText(state+"\n"+message); status.setTextColor(failed?Color.RED:Color.rgb(30,50,70));
        if(!gate.blocked()) preview.setVisibility(View.VISIBLE);
        if(evidence!=null) evidence.setText("Empfang: "+(scanning?"angefordert / aktiv":"aus")+"\nKamera geschlossen: "+cameraClosed+"\nFinalisierung ausstehend: "+finalizing+"\nLetzte Datei: "+(lastVideo==null?"keine":lastVideo.getName()+" ("+lastVideo.length()+" Bytes)")+"\nKein Hardware-Wirksamkeitsnachweis durch diese Anzeige. Gepufferte Frames können beim Stoppen noch finalisiert werden.");
    }
    private void log(String event,String detail) {
        try(FileWriter w=new FileWriter(new File(directory,"events.csv"),true)) {
            w.write(System.currentTimeMillis()+","+SystemClock.elapsedRealtime()+","+event+","+detail.replace(',',';').replace('\n',' ')+"\n");
        } catch(IOException e) { failed=true; message="Testprotokoll konnte nicht geschrieben werden."; }
    }
    private void shareVideo(boolean share) {
        if(recording!=null || finalizing || lastVideo==null || !lastVideo.exists()) { message="Keine abgeschlossene Testdatei verfügbar."; render(); return; }
        var uri=FileProvider.getUriForFile(this,getPackageName()+".files",lastVideo);
        Intent i=new Intent(share?Intent.ACTION_SEND:Intent.ACTION_VIEW);
        if(share) { i.setType("video/mp4"); i.putExtra(Intent.EXTRA_STREAM,uri); }
        else i.setDataAndType(uri,"video/mp4");
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try { startActivity(Intent.createChooser(i,share?"Testvideo bewusst weitergeben":"Testvideo prüfen")); }
        catch(RuntimeException e) { message="Keine passende Video-App vorhanden."; render(); }
    }
    private void shareLog() {
        File file=new File(directory,"events.csv"); if(!file.exists()) { message="Noch kein Protokoll."; render(); return; }
        Intent i=new Intent(Intent.ACTION_SEND).setType("text/csv");
        i.putExtra(Intent.EXTRA_STREAM,FileProvider.getUriForFile(this,getPackageName()+".files",file));
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try { startActivity(Intent.createChooser(i,"Lokales Protokoll teilen")); } catch(RuntimeException e) { message="Keine passende App vorhanden."; render(); }
    }
    @Override public void onRequestPermissionsResult(int r,String[] p,int[] g) {
        super.onRequestPermissionsResult(r,p,g); message="Berechtigungen aktualisiert. Empfang erneut starten."; render();
    }
    @Override protected void onStart() { super.onStart(); foreground=true; }
    @Override protected void onStop() { foreground=false; stopScan(); restrict("App nicht im Vordergrund: Test angehalten"); super.onStop(); }
    @Override protected void onDestroy() { unregisterReceiver(bluetoothState); stopScan(); handler.removeCallbacksAndMessages(null); qrExecutor.shutdown(); super.onDestroy(); }
}
