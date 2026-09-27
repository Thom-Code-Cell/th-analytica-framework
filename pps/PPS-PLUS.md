# PPS+ — Personal Policy Layer

Status: **Experimental PPS extension proposal**  
Prepared: 2026-09-27  
Maintainer: Thomas Hullin / TH Analytica

## Purpose

PPS Draft v1.0 currently expresses a strict local privacy preference through
PPS MAXIMUM.

PPS+ adds an optional richer policy layer for Physical-AI systems that need to
distinguish between:

1. capture;
2. inference;
3. identification;
4. retention / sharing;
5. action.

The goal is to avoid a false binary between "AI may do everything" and
"all sensing must be disabled".

A safety-capable device may, for example, need transient perception for
navigation, collision avoidance or emergency detection while identification,
profiling, training and ordinary cloud retention remain denied.

## Core principle

> Minimum perception. Minimum inference. Maximum necessary assistance.

PPS+ must not be represented as permission for generalized surveillance.

Safety assistance and law-enforcement reporting are separate policy domains.

## Current Android PPS+ candidate

The current public Android beta is:

- public package: `com.thanalytica.pps`
- app version: `1.1.0-beta1`
- versionCode: `13`
- existing PPS MAXIMUM BLE payload: unchanged
- PPS+ policy storage: local to the user's Android device
- identity in PPS+ policy: none required
- policy export: readable summary, JSON, compact `pps://` URI and QR code

The signed Android beta is available from https://th-analytica.com/pps-privacy-signal.

Published APK SHA-256:
`a3f72caa3bfc140acfa4838f97ff2b0d2d4b7a42e191b34bfdc1bb8ca34a3119`

This is a working PPS+ reference implementation, not a claim of commercial-device support.

## Policy domains

### Capture

Controls whether ordinary sensor capture is requested to be denied and whether
narrow transient safety processing is allowed.

### Inference

Controls what AI may infer from sensor input.

Examples:

- safety / emergency inference;
- identification;
- profiling;
- emotion inference.

### Retention and use

Controls whether derived information may be retained or reused.

Examples:

- retention duration;
- training;
- commercial use;
- external sharing.

### Action

Controls what the device may do because of an inference.

Examples:

- alert the wearer;
- take a local safety action;
- request user confirmation before contacting emergency services;
- prohibit automatic general law-enforcement reporting.

## Reference beta policy

A conservative reference policy can express:

- ordinary capture: DENY
- safety/emergency transient processing: ALLOWED
- identification: DENY
- profiling: DENY
- emotion inference: DENY
- training: DENY
- commercial use: DENY
- retention by default: 0 seconds
- user safety alert: AUTOMATIC
- emergency-service contact: USER_CONFIRMATION_REQUIRED
- automatic general law-enforcement reporting: DENY
- emergency-only location sharing: optional
- emergency-only identity disclosure to authorised emergency services: optional

A future safety-reviewed profile may define narrowly scoped automatic emergency
escalation for immediate life-threatening cases. This is not a general default
and must not be used as a shortcut for policing, behavioural monitoring or
automatic accusation.

## Transport relationship

PPS+ does not replace the current PPS BLE wire format in the first candidate.

The current fast local signal remains suitable for nearby discovery and strict
PPS MAXIMUM handling.

A future Candidate release may define a standard discovery mechanism for a
richer PPS+ policy after privacy, security, anti-abuse and interoperability
review.

## Machine-readable schema

Reference schema:

[pps-plus-policy.schema.json](pps-plus-policy.schema.json)

The schema is intentionally descriptive and experimental. It is not yet a
Stable PPS conformance target.

## Manufacturer integration

Manufacturers may evaluate PPS+ after the basic PPS pilot.

A useful PPS+ proof of concept could demonstrate:

1. PPS presence detected locally;
2. ordinary capture or personal processing restricted;
3. navigation/safety processing kept narrowly available where appropriate;
4. identity and profiling blocked;
5. no persistent sender identity created;
6. user-visible indication of the active policy;
7. external escalation only under the declared action policy.

## Legal and safety boundary

PPS+ is a technical policy expression.

It does not override applicable law, emergency duties, mandatory recording
rules or lawful public-authority processing.

Any exception should be documented, narrow, auditable and visible to the
responsible operator or system owner.


## Compact QR policy

The Android reference implementation can encode the personal policy as a
compact `pps://policy/0.1` URI for QR-based exchange.

The compact representation repeats fixed privacy restrictions explicitly so it
has the same restrictive meaning as the JSON representation. Current fields
include:

- `cap`: ordinary capture
- `id`: identification
- `prof`: profiling
- `train`: training
- `safety`: safety/emergency inference
- `alert`: user warning
- `emergency`: emergency-service escalation
- `loc`: emergency-only location disclosure
- `eid`: emergency-only identity disclosure
- `emotion`: emotion inference
- `ret`: default retention
- `cuse`: commercial use
- `cact`: commercial action
- `law`: automatic general law-enforcement reporting

If safety inference is `deny`, alert, emergency escalation, emergency location
and emergency identity disclosure are also serialized as `deny`.

The compact URI is experimental and versioned. Implementers must not infer
permission from an omitted field.
