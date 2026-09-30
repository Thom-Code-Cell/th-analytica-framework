package com.thanalytica.pps.receiver;
import org.junit.Test;
import static org.junit.Assert.*;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
public class QrPolicyTest {
 private static final String POLICY="pps://policy/0.1?cap=deny&id=deny&prof=deny&train=deny&safety=allow&alert=automatic&emergency=auto-high-confidence&loc=emergency-only&eid=emergency-only&emotion=deny&ret=0&cuse=deny&cact=deny&law=deny";
 @Test public void actualPayloadRestricts() { assertEquals(QrPolicy.Verdict.RESTRICT,QrPolicy.parse(POLICY)); }
 @Test public void otherCodesIgnored() {
  assertEquals(QrPolicy.Verdict.IGNORE,QrPolicy.parse("BEGIN:VCARD\nVERSION:3.0\nEND:VCARD"));
  assertEquals(QrPolicy.Verdict.IGNORE,QrPolicy.parse("https://example.org"));
 }
 @Test public void ambiguousPoliciesFailClosed() {
  for(String p:new String[]{POLICY+"&cap=allow",POLICY.replace("/0.1?","/9?"),POLICY.replace("&law=deny",""),POLICY+"&x=1",POLICY.replace("cap=deny","cap=%64eny"),POLICY+"#fragment"})
   assertEquals(p,QrPolicy.Verdict.INVALID,QrPolicy.parse(p));
 }
 @Test public void safetyDoesNotOverrideCapture() { assertEquals(QrPolicy.Verdict.RESTRICT,QrPolicy.parse(POLICY)); }
 @Test public void allowDoesNotMeanRelease() { assertEquals(QrPolicy.Verdict.NO_CAPTURE_RESTRICTION,QrPolicy.parse(POLICY.replace("cap=deny","cap=allow"))); }
 @Test public void decoderRoundtrip() throws Exception {
  BitMatrix matrix=new QRCodeWriter().encode(POLICY,BarcodeFormat.QR_CODE,600,600);
  int[] pixels=new int[360000];
  for(int y=0;y<600;y++) for(int x=0;x<600;x++) pixels[y*600+x]=matrix.get(x,y)?0xff000000:0xffffffff;
  String decoded=new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(600,600,pixels)))).getText();
  assertEquals(POLICY,decoded); assertEquals(QrPolicy.Verdict.RESTRICT,QrPolicy.parse(decoded));
 }
}
