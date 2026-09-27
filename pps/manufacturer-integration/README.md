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

The checked public Android release remains 1.0.0-beta2 until the PPS+ build,
signature and upgrade test are completed.
