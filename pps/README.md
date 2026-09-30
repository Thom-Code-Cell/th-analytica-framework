# Personal Privacy Signal (PPS) governance pack

This directory contains the governance, provenance, conformance, trademark-use and security rules for the TH Analytica Personal Privacy Signal (PPS) project.

Canonical protocol specification: [../personal-privacy-signal.md](../personal-privacy-signal.md)

## Project principles

- Keep the wire format and interoperability path implementation-friendly.
- Detect privacy preference, not identity.
- Separate technical implementation from endorsement, certification and branding.
- Never imply that a third-party device supports or enforces PPS unless that behavior is actually implemented and tested.
- Keep evidence, limitations and unresolved security work explicit.

## Documents

- [ORIGIN.md](ORIGIN.md) — provenance and canonical source
- [GOVERNANCE.md](GOVERNANCE.md) — decision and change process
- [CONFORMANCE.md](CONFORMANCE.md) — technical compatibility criteria
- [conformance/](conformance/README.md) — public Draft v1.0 wire-format test vectors
- [TRADEMARK-POLICY.md](TRADEMARK-POLICY.md) — rules for names, badges and compatibility claims
- [VERSIONING.md](VERSIONING.md) — draft, candidate and stable version rules
- [SECURITY.md](SECURITY.md) — disclosure and security expectations
- [LICENSING-PLAN.md](LICENSING-PLAN.md) — planned open-core licensing split; not yet an active licence
- [project.json](project.json) — machine-readable provenance metadata
- [BASELINE-DRAFT-v1.0.md](BASELINE-DRAFT-v1.0.md) — frozen Draft v1.0 reference
- [manufacturer-integration/](manufacturer-integration/README.md) — manufacturer evaluation and pilot kit

Until an explicit licence file is adopted, do not infer unrestricted permission to copy, modify or redistribute project material merely because the repository is public.


## Android receiver source for evaluation (2026-09-30)

[Reference receiver 0.2.0-test](reference-receiver-android/README.md) includes BLE reception,
local QR decoding, CameraX capture controls, build instructions and ten automated tests.
[Integration examples and physical acceptance tests](reference-receiver-android/INTEGRATION.md) explain
how to reproduce the experiment. BLE device observations apply to 0.1.0-test;
QR hardware tests and BLE regression tests for 0.2.0-test remain pending.
This is experimental public source, not a certified SDK. Existing licensing restrictions remain;
see the reference README before product integration or redistribution.
