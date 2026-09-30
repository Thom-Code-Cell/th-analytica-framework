# PPS Manufacturer Integration Kit

Status: Draft v1.0 integration material
Audience: smart-glasses, wearable, camera, operating-system and Physical-AI engineering teams

## Goal

Give a manufacturer enough information to evaluate Personal Privacy Signal (PPS) without reverse-engineering the Android reference app.

## Start here

0. [`00-handoff-pack.md`](00-handoff-pack.md) — single manufacturer handoff entry point
1. `01-technical-quick-start.md`
2. `02-integration-checklist.md`
3. `03-pilot-plan.md`
4. `04-vendor-questionnaire.md`
5. `../conformance/README.md`

Canonical specification: `../../personal-privacy-signal.md`

## Current checked Android reference build

- applicationId: `com.thanalytica.pps`
- version: `1.0.0-beta2`
- versionCode: `12`
- protocol: PPS Draft v1.0

PPS remains experimental. This kit does not claim adoption by any commercial smart-glasses vendor.


## PPS+ candidate

A richer optional policy layer is available for manufacturer evaluation:

- `../../pps/PPS-PLUS.md`
- `../../pps/pps-plus-policy.schema.json`

Candidate Android version: `1.1.0-beta1` / versionCode `13`.

The current public Android release is PPS+ 1.1.0-beta1 / versionCode 13.
The signed APK is published through the official TH Analytica PPS page.

SHA-256:
`38e1a66c4b46910d09c4756a21dcbf0f4b96f9765a311051d4327a97a05c9eec`

Package ID remains `com.thanalytica.pps`; the release signer is continuous
with 1.0.0-beta2 for in-place Android updates.


## Android receiver source for evaluation (2026-09-30)

[Reference receiver 0.2.0-test](../reference-receiver-android/README.md) includes BLE reception,
local QR decoding, CameraX capture controls, build instructions and ten automated tests.
[Integration examples and physical acceptance tests](../reference-receiver-android/INTEGRATION.md) explain
how to reproduce the experiment. BLE device observations apply to 0.1.0-test;
QR hardware tests and BLE regression tests for 0.2.0-test remain pending.
This is experimental public source, not a certified SDK. Existing licensing restrictions remain;
see the reference README before product integration or redistribution.


## Discuss a scoped pilot

[Paid manufacturer feasibility pilot](05-paid-pilot.md): scope, prerequisites,
phase gates, evidence and contact. Pricing and implementation rights are agreed separately.
