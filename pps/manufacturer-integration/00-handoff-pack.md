# PPS Manufacturer Handoff Pack

Version: PPS Draft v1.0
Prepared: 2026-09-27
Maintainer: Thomas Hullin / TH Analytica

This page is the single entry point for a manufacturer, platform or privacy-engineering team evaluating Personal Privacy Signal (PPS).

## 1. Canonical specification

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/personal-privacy-signal.md

Use this as the authoritative protocol and governance reference.

## 2. Technical quick start

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/manufacturer-integration/01-technical-quick-start.md

Contains the BLE transport, experimental service-data UUID, 8-byte payload layout, privacy levels, DENY flags and receiver minimum behavior.

## 3. Integration checklist

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/manufacturer-integration/02-integration-checklist.md

Use this to map PPS to the actual capabilities and limitations of a device or platform.

## 4. Limited pilot plan

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/manufacturer-integration/03-pilot-plan.md

Defines a small proof of concept without requiring a product commitment.

## 5. Vendor technical questionnaire

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/manufacturer-integration/04-vendor-questionnaire.md

The answers help determine whether PPS belongs at firmware, OS, companion-app or application level.

## 6. Public conformance vectors

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/conformance/test_vectors.json

Positive and negative Draft v1.0 wire-format vectors are provided for parser testing.

Conformance notes:
https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/conformance/README.md

## 7. Frozen Draft v1.0 baseline

https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/BASELINE-DRAFT-v1.0.md

Immutable baseline commit:
`445caad6b225a6df01ba4f66a051089b0b6c07c5`

## Current Android reference implementation

- applicationId: `com.thanalytica.pps`
- current public version: `1.1.0-beta1`
- versionCode: `13`
- transport: Bluetooth Low Energy Service Data
- public sender: no account required
- ordinary protection mode: no camera, microphone or GPS/location collection
- rotating temporary token
- PPS MAXIMUM expresses seven DENY preferences

## PPS+ policy extension

For devices that need more nuance than a binary capture block, PPS+ adds a
machine-readable policy layer for capture, inference, identification,
retention/sharing and action permissions.

- Overview: https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/PPS-PLUS.md
- JSON Schema: https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/pps-plus-policy.schema.json

PPS+ Android Beta `1.1.0-beta1` / versionCode `13` is publicly available.
The original BLE PPS MAXIMUM payload remains unchanged for compatibility.

Public Android download:
https://th-analytica.com/pps-privacy-signal

Published APK SHA-256:
`38e1a66c4b46910d09c4756a21dcbf0f4b96f9765a311051d4327a97a05c9eec`

The Android package remains `com.thanalytica.pps` and uses the same stable
release signer as Beta 1.0.0-beta2 so existing Beta-2 installations can be
updated in place.


## Vendor-specific feasibility studies

These studies map PPS to public vendor SDK surfaces without claiming adoption,
endorsement or compatibility.

- HTC VIVE Eagle:
  https://github.com/Thom-Code-Cell/th-analytica-framework/blob/main/pps/manufacturer-integration/vendor-studies/htc-vive-eagle.md

## Evaluation request

A manufacturer does not need to support every PPS flag to run a pilot.

The first useful proof of concept is:

1. detect a valid PPS Draft v1.0 signal;
2. parse it correctly;
3. map at least one supported privacy request to real local behavior;
4. avoid identifying the signal sender;
5. restore normal behavior after the request expires;
6. document unsupported flags and exceptions.

## Important boundaries

- PPS Draft v1.0 is experimental.
- It does not claim that current third-party products already support PPS.
- The signal is not cryptographically authenticated in Draft v1.0.
- Passing the public wire-format vectors is not official certification.
- The preferred official compatibility wording is **Personal Privacy Signal Compatible**.
- Legal, safety and product responsibilities remain with the receiving implementation.

Technical contact:
Thomas Hullin
TH Analytica
Switzerland
thomas@th-analytica.com
https://th-analytica.com/pps-privacy-signal


## Android receiver source for evaluation (2026-09-30)

[Reference receiver 0.2.0-test](../reference-receiver-android/README.md) includes BLE reception,
local QR decoding, CameraX capture controls, build instructions and ten automated tests.
[Integration examples and physical acceptance tests](../reference-receiver-android/INTEGRATION.md) explain
how to reproduce the experiment. BLE device observations apply to 0.1.0-test;
QR hardware tests and BLE regression tests for 0.2.0-test remain pending.
This is experimental public source, not a certified SDK. Existing licensing restrictions remain;
see the reference README before product integration or redistribution.
