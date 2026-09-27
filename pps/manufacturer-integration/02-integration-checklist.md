# PPS manufacturer integration checklist

## Discovery and parsing
- [ ] Detect the Draft v1.0 service-data UUID.
- [ ] Require/document 8-byte payload handling.
- [ ] Validate the protocol version.
- [ ] Parse level, DENY flags, reserved byte and big-endian token.
- [ ] Define safe behavior for malformed packets and unknown versions.

## Privacy
- [ ] Do not derive a persistent person identity from rotating PPS tokens.
- [ ] Minimise token logging and retention.
- [ ] Document any telemetry involving PPS.
- [ ] Consider scene-level handling before person identification.

## Policy mapping
- [ ] Document actual behavior for capture DENY.
- [ ] Document actual behavior for audio DENY.
- [ ] Document actual behavior for face/biometric DENY.
- [ ] Document actual behavior for AI-analysis DENY.
- [ ] Document actual behavior for cloud/training DENY.
- [ ] Explicitly disclose unsupported flags.
- [ ] Explicitly document safety/legal exceptions.

## Reliability
- [ ] Test signal appearance and disappearance.
- [ ] Test restart behavior.
- [ ] Test multiple nearby PPS signals.
- [ ] Test malformed payloads and unknown versions.
- [ ] Ensure user-visible protection state cannot remain active after receiver failure.

## Evidence bundle
- [ ] Product/build identifier.
- [ ] PPS protocol version.
- [ ] Test-suite version.
- [ ] Test date.
- [ ] Known exceptions.
- [ ] Security contact.
