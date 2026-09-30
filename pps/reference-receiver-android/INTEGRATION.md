# Manufacturer integration and acceptance tests

Status: experimental reference 0.2.0-test, published 2026-09-30.

## Where to integrate

PrivacyGate.java validates BLE service data and implements a restrictive latch.
QrPolicy.java validates decoded PPS URI text. ReceiverActivity.java connects
foreground BLE scanning, local ZXing decoding, CameraX stop/unbind and local evidence logging.
Replace these app-level camera controls with your own supported capture pipeline.
Parsing a policy alone does not stop recording, cloud uploads, identification or training.
This app controls only its own silent local video recorder. It does not implement
emergency calls, location sharing, AI processing, authentication or hostile-drone defence.

## Transport examples

BLE service-data UUID: `7b2f4d10-9a6e-4ce7-8b7f-6d5050530001`.
Eight service-data bytes, hexadecimal: `01 03 7f 00 01 02 03 04`.
Byte 0: version 1; byte 1: privacy level 3; byte 2: DENY bits 0–6;
byte 3: reserved zero; bytes 4–7: illustrative rotating token, not authentication.
The UUID is the service-data key, not part of these eight bytes.
This conservative demo blocks the entire camera for maximum privacy or any DENY bit.

QR payload, exact text to encode with a QR encoder:

```text
pps://policy/0.1?cap=deny&id=deny&prof=deny&train=deny&safety=allow&alert=automatic&emergency=auto-high-confidence&loc=emergency-only&eid=emergency-only&emotion=deny&ret=0&cuse=deny&cact=deny&law=deny
```

Only cap=deny triggers capture restriction for a valid QR policy. Other fields are
validated but not implemented as actions. The parser accepts an intentionally narrow
profile: all fourteen keys are required, duplicate/unknown keys, percent-encoded values,
unsupported versions and unknown values are invalid. This is not a general URI normalizer
or complete PPS+ conformance implementation. Recognized but invalid pps: text blocks
conservatively. Non-PPS QR text is ignored and never executed or opened.

## Physical acceptance matrix

Use consenting participants or a test chart. Log model, OS, versions, distance,
lighting, repetitions, failures and the exact source commit.
Keep Bluetooth enabled on the receiver for both tests. For QR isolation, stop the
sender's BLE advertising and display a saved QR image on the other device.
Start receiver scanning, wait five seconds, manually release preview, then record.

| Test | Expected result | Evidence |
|---|---|---|
| No restriction; no QR | Recording continues until manual stop or file limit | Timed control video and log |
| Restrictive BLE service data | Stop and camera close | pps_received, stop_requested, record_finalized |
| Valid cap=deny QR | Stop and camera close | qr_policy_received RESTRICT, stop_requested, record_finalized |
| Decodable malformed PPS URI | Conservative block | qr_policy_received INVALID |
| Ordinary URL/vCard QR | No policy action or URL opening | Observe continued recording |
| QR removed or BLE sender stopped | No automatic restart | Observe latched state; explicit release required |
| Bluetooth/permission loss or app backgrounded | Camera blocked | State and recording completion |
| Unsupported simultaneous camera streams | Error and camera blocked | No silent QR-free fallback |

For successful stop trials, require error=0 at finalization, inspect the saved clip
and compare file_size_check before/after sizes. Check the camera-closed indicator
separately. A blinking LED or a displayed privacy message is not proof of stopped capture.
CSV columns are wall-clock milliseconds, elapsedRealtime milliseconds, event, detail
(no header). Use the monotonic column for intervals. stop_ms measures stop request
to finalization, not transmitter activation to the last captured frame. The size check
runs about two seconds after finalization and is not forensic proof of no future writes.

## Limits to retain in any integration

QR scanning needs camera frames. Frames may be captured and saved before decoding;
there is no retroactive deletion. Unreadable or out-of-frame QR codes cannot trigger a
restriction. A five-second wait after a QR restriction does not prove that the marker
is absent: the closed camera cannot inspect it until manually reopened.
BLE can miss packets. Neither transport authenticates the sender or prevents replay
or denial of service. Do not use this demo for safety-critical recording.
No automatic emergency exception, certification or legal compliance is asserted.
