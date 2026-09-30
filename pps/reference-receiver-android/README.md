# PPS Android reference receiver 0.2.0-test

Separate experimental Android app: `com.thanalytica.pps.receiver`. Does not update or replace the public PPS sender. Built from the current project's Draft v1 BLE format (sender package com.thanalytica.pps, current source version 1.1.0-beta1). PPS URI 0.1 QR codes are decoded locally; only the capture restriction is enforced.

## Scope
Foreground-only, local silent video recording, strict BLE parser, restrictive latch, manual release after five seconds of scanning without a restrictive/invalid PPS packet. Any DENY flag is conservatively applied to the entire camera. This is a test policy, not general PPS+ conformance or certification.

No Internet, microphone, advertising, analytics or account. Android 8–11 require location permission and enabled location services for BLE; coordinates are never queried. Android 12+ use Nearby devices permissions. No BLE addresses or rotating tokens in logs. Camera opens only after explicit test release. Stop is requested immediately when a restrictive packet is processed; CameraX Finalize and camera CLOSED are separately observed. Buffered frames can still be written before finalization. File size is checked two seconds afterwards; this is not independent forensic proof of zero future writes.

Initial startup, lifecycle changes, Bluetooth loss and scan failures leave the camera blocked. A missing signal is never consent. A foreground scanner can silently miss advertisements: no universal detection or range guarantee. Signal spoofing/replay and denial of service are not solved. Never use for security-critical recording or drone control.

## Two-device test
1. Install the existing public PPS/PPS+ sender on phone A. Install this separate test APK on phone B.
2. Initially disable the sender. On B grant requested permissions and press BLE-Empfang starten. Android 8–11 may require location services enabled.
3. After five seconds press Manuell freigeben + Vorschau, then Lokale Testaufnahme starten. Use a clock/stopwatch in view, no bystanders.
4. Activate PPS MAXIMUM on A. B must show stop requested, then recording inactive and camera closed. If an error appears, do not interpret it as successful protection.
5. Open the saved clip and compare its last visible frame with the local event log. Measure reception-to-finalization time, not theoretical radio time. Check file_size_check before/after values.
6. Disable A. B must remain blocked. After a quiet interval only explicit manual release may reopen preview; recording still requires another button press.
7. Repeat with Bluetooth off, permissions denied/revoked, screen locked, app backgrounded, rapid start/stop and a second sender. No automatic recording restart is acceptable.
8. Use the simulation button only to test app controls; it is explicitly not evidence of BLE reception.
9. Share videos/logs only deliberately. Delete test files afterwards. App uninstall removes internal files.

Record both phone models, Android versions, sender/receiver builds, distance, obstructions, repetitions, observed results and failures. First installation on actual phones, real BLE reception, camera behavior and frame cutoff require physical testing; they cannot be validated by a cloud build.

## Build
JDK 17, Gradle 9.1.0, Android SDK 36. `gradle :app:testDebugUnitTest :app:assembleDebug :app:lintDebug`.
Debug APK is for controlled evaluation, not a production release. Unit tests cover strict payload validation, latch behavior, conflicting senders and explicit release. Camera behavior needs real devices.

Source references: https://developer.android.com/media/camera/camerax/video-capture and https://developer.android.com/develop/connectivity/bluetooth/ble/find-ble-devices (checked 2026-09-30).

## 0.2.0-test: lokale QR-Erkennung
Die Vorschau und Testaufnahme nutzen zusätzlich CameraX ImageAnalysis und ZXing
(keine KI, kein Netzwerk). Mindestens ca. 200 ms Abstand zwischen analysierten Frames.
PPS-URI 0.1 wird strikt geprüft; cap=deny sperrt die eigene Kamera. Andere gültige
Flags werden nicht als Notruf, Standortfreigabe oder KI-Verarbeitungsfunktion ausgeführt.
Unbekannte/ungültige PPS-URIs sperren vorsorglich. Fremde QR-Inhalte werden weder
geöffnet noch protokolliert. Kein automatischer Neustart nach QR-Verlust.

Test: BLE-Empfang starten (Sender aus), manuell freigeben, Aufnahme starten,
PPS-QR auf zweitem Bildschirm ins Blickfeld bringen. Erwartet: qr_policy_received,
stop_requested, record_finalized und unveränderte Dateigrösse. QR entfernen,
mindestens fünf Sekunden warten, manuell freigeben. Separat BLE erneut testen.
Auch einen fremden QR und einen ungültigen PPS-QR testen. Vor Erkennung sind Frames
bereits erfasst und bei laufender Aufnahme gespeichert; keine rückwirkende Löschung.
QR-Erkennung hängt von Sichtbarkeit, Grösse, Abstand und Beleuchtung ab.
Vorschau + Video + Analyse wird nicht von jedem Gerät unterstützt. Bei Bindefehler
bleibt die Kamera gesperrt; kein stiller Rückfall auf Betrieb ohne QR-Analyse.
Geräteprüfung dieser neuen Version steht noch aus. Die drei bisherigen BLE-Tests
beziehen sich auf 0.1.0-test.


## Manufacturer starting point

This is a standalone Java/CameraX evaluation app, not an SDK or a system-wide camera service.
See [integration and acceptance tests](INTEGRATION.md) and the
[reported BLE device experiment](../tests/2026-09-30-android-camera-stop.md).
The 0.2.0-test source passed Android build, unit tests and lint before publication.
The three reported physical BLE trials used 0.1.0-test. QR hardware testing and BLE
regression testing on 0.2.0-test are pending. No commercial glasses were tested.

### Reproduce the build

Install JDK 17, Gradle 9.1.0 and Android SDK Platform 36; accept the Android SDK licences.
Set ANDROID_HOME to your SDK directory. This source snapshot does not include a Gradle wrapper.

```sh
git clone https://github.com/Thom-Code-Cell/th-analytica-framework.git
cd th-analytica-framework/pps/reference-receiver-android
gradle --no-daemon :app:testDebugUnitTest :app:assembleDebug :app:lintDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Test reports: app/build/reports/tests/testDebugUnitTest/ and app/build/reports/lint-results-debug.html.
Ten JUnit tests cover policy logic and a generated QR encode/decode roundtrip; they do not
validate a physical camera, radio reception, or end-to-end timing.
A locally generated debug signing key may differ from a previous build. Export local
videos/logs before uninstalling an old receiver if Android rejects an update.
Do not uninstall the separate sender to resolve a receiver signing conflict.

## Permissions and licensing

Public source availability is not a general software licence. The existing
[licensing plan](../LICENSING-PLAN.md) remains in effect; no new commercial reuse,
redistribution, patent or branding grant is introduced by this publication.
Resolve applicable permissions with TH Analytica before product integration or redistribution.
AndroidX and ZXing dependencies retain their own licences. No dependency source is vendored here.
