# PPS: scoped manufacturer pilot
Updated 2026-09-30. Experimental programme proposal.

TH Analytica invites smart-glasses, wearable and camera engineering teams to discuss
a paid, limited feasibility pilot: can a local PPS recording restriction be enforced
inside a capture pipeline the manufacturer controls?

## What exists today
- [Android reference receiver, source and build instructions](../reference-receiver-android/README.md).
- [Signal examples and acceptance tests](../reference-receiver-android/INTEGRATION.md).
- [Three reported BLE recording-stop trials](../tests/2026-09-30-android-camera-stop.md)
  on Samsung Galaxy S10+ / Galaxy Tab A8 using receiver 0.1.0-test.
- Receiver 0.2.0-test includes local QR decoding and passed automated build/tests/lint.
  Physical QR testing and BLE regression testing on this version remain pending.

No commercial smart-glasses implementation, independent certification or manufacturer
partnership is claimed.

## Phase A: feasibility before integration
Evaluate one device and SDK, supported signal reception, camera-control APIs,
local/cloud data flow and integration boundaries. Deliver a written go/no-go assessment
and a scoped integration proposal. Missing device APIs may result in a valid no-go conclusion.

## Phase B: agreed prototype
Subject to phase A, implement an agreed experimental adapter for one device/version,
one recording pipeline and one transport (BLE or QR). Provide reproducible tests,
event evidence, limitations and a technical handover.
Scope, price, schedule, devices and responsibilities are agreed before work starts.
Production deployment and additional platforms are separate work.

## What we need from a partner
A technical contact, a specific device/SDK, authorised development access and a test device
or supported remote test arrangement. Please identify where recording occurs and whether
the available API actually controls it. Evaluation and production-use permissions must
be agreed separately under the project's [current licensing status](../LICENSING-PLAN.md).

## Success criteria
Verify recognition, actual recording stop, finalization, saved-file behavior and no automatic
restart. Record failures as well as successful trials. Agree timing and environmental criteria
before testing. A UI message or LED alone is insufficient evidence.
A pilot delivers documented findings; it is not a promise of universal device compatibility.

## Boundaries
Only explicitly integrated software can respond. QR recognition requires camera frames,
so images may already have been captured. BLE reception and optical visibility are imperfect.
Anti-spoofing and replay protection are unresolved. No general legal compliance guarantee,
emergency calling, unrelated-camera control, hostile-drone defence or safety-critical use
is offered by this reference app.

## Contact
Thomas Hullin / TH Analytica: [thomas@th-analytica.com](mailto:thomas@th-analytica.com)

Please include your device model, SDK/firmware version, capture-control interface,
intended evaluation and technical contact. Do not include sensitive user recordings.
