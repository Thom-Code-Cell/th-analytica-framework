# TH Analytica Personal Privacy Signal (PPS) — Draft v1.0

Status: **Experimental open protocol proposal**  
Updated: 2026-09-24

## Direct answer

Personal Privacy Signal (PPS) is a local, machine-readable privacy preference for Physical-AI environments.

A person can broadcast a short anonymous signal from a compatible device such as a smartphone. A compatible receiver can interpret the signal as a request to restrict capture and personal-data processing.

PPS does **not** currently force third-party Smart Glasses, cameras, robots or operating systems to comply. Enforcement requires support by the receiving manufacturer, operating system or application and must remain subject to applicable law and safety requirements.

## Design principle

> Detect the privacy request, not the identity.

PPS must not require the receiver to learn the name, account, phone number, e-mail address or persistent device identity of the person requesting privacy.

## Collective Privacy Shield

The reference behavior is **Collective Privacy Shield**.

A compatible receiver may apply the strict PPS policy to the complete camera scene while a valid PPS request is present.

This is intentional:

- people without the app can benefit;
- children and other bystanders can benefit;
- the receiver does not need to identify which face belongs to the transmitter;
- person-to-device identity linking is avoided.

Collective scene protection is a privacy-preserving default, not a universal rule for every environment. Safety-critical, legally required or explicitly authorised recording systems need their own documented policy and human accountability.

## PPS MAXIMUM policy

The current Android reference implementation transmits the following DENY preferences:

- capture: DENY
- audio: DENY
- facial recognition: DENY
- biometric processing: DENY
- AI analysis: DENY
- cloud upload: DENY
- training: DENY

These are preference signals. Their legal effect and technical enforcement depend on the receiving context.

## Reference BLE transport

The Android reference implementation uses Bluetooth Low Energy Service Data.

PoC service-data UUID:

`7b2f4d10-9a6e-4ce7-8b7f-6d5050530001`

This UUID is experimental and must not be represented as an allocated industry-standard UUID.

### Payload

8 bytes, big-endian:

| Offset | Bytes | Field |
|---|---:|---|
| 0 | 1 | protocol version |
| 1 | 1 | privacy level |
| 2 | 1 | DENY flags |
| 3 | 1 | reserved |
| 4 | 4 | rotating random token |

The reference sender rotates the random token every 30 seconds.

The token has no semantic identity meaning and must not be used as a permanent person or device identifier.

## Privacy requirements

A compliant PPS implementation should:

1. avoid transmitting a stable personal identifier;
2. avoid transmitting a stable device identifier in the PPS payload;
3. avoid requiring a cloud account for the local privacy signal;
4. rotate temporary values frequently;
5. minimise logs and keep diagnostic logs local unless explicitly shared;
6. separate ordinary protection mode from developer diagnostics;
7. clearly disclose permissions and limitations;
8. avoid claiming protection when the local broadcast failed.

The TH Analytica privacy-by-design standard remains mandatory.

## Receiver behavior

A compatible receiver should:

1. validate that the received payload matches a supported PPS version;
2. treat the request as a privacy preference rather than proof of identity;
3. avoid creating a persistent identity from rotating tokens;
4. apply the strictest supported applicable policy within its documented context;
5. provide clear human-visible indication where appropriate;
6. restore ordinary operation only after the request is no longer applicable;
7. log only what is necessary for audit, safety or legal obligations;
8. document exceptions where recording is safety-critical, legally required or explicitly authorised.

## Signal range

Bluetooth signal strength is not a reliable distance measurement.

Walls, bodies, device orientation, radio hardware and interference affect RSSI.

The Android reference implementation therefore exposes transmit-power settings for practical calibration but does not claim that a particular RSSI or power level equals a fixed number of metres.

Precise person-to-camera association is not required for Collective Privacy Shield.

## Location + person governance

PPS complements, rather than replaces, location governance.

Two policy surfaces can coexist:

- **Personal Privacy Signal:** a person or personal device broadcasts a privacy preference.
- **Location Physical AI Policy:** a venue defines rules for a room, zone or property.

Where both apply, a compatible implementation should use the stricter supported privacy restriction unless a documented legal or safety exception applies.

## Threat model and unresolved work

Draft v1.0 does **not** solve anonymous sender authentication.

Because an open BLE payload can be imitated, a malicious transmitter could attempt to create persistent false privacy requests or broad denial-of-service behavior.

A production standard therefore needs privacy-preserving anti-spoofing and anti-abuse measures without introducing a permanent person identifier.

Areas for further work include:

- short-lived anonymous credentials;
- unlinkable OS-backed attestation;
- replay resistance;
- rate and duration limits;
- multi-signal conflict handling;
- safety-critical recording exceptions;
- optional UWB or other ranging where precise proximity is genuinely needed;
- Wear OS and iOS reference implementations;
- independent security and privacy review.

No unresolved protection may be represented as already implemented.

## Reference implementation

Android Beta 1.0:

- package: `ch.thanalytica.pps`
- minimum Android API: 26
- current reference modes: sender, Collective Privacy Shield demo receiver, RSSI laboratory mode
- no user account required
- no Internet permission in ordinary protection mode
- no analytics or advertising SDK

Public project page:

- https://th-analytica.com/pps-privacy-signal
- https://th-analytica.com/pps-datenschutz

## Evidence labels

- **Implemented:** Android BLE sender, rotating token, PPS MAXIMUM flags, demo receiver, Collective Privacy Shield reference behavior, local diagnostic logging.
- **Experimental:** open PPS protocol proposal, configurable radio range, automatic receiver interpretation.
- **Not measured:** native recognition by commercial Smart Glasses or operating systems.
- **Not available:** universal forced control of arbitrary third-party devices.
- **Unresolved:** standardised privacy-preserving sender authentication and anti-denial-of-service protection.

## Governance

The protocol should remain implementation-friendly for device manufacturers.

The protocol definition may be openly implemented, while TH Analytica branding, certification, assessment and governance services remain separate from the open technical format.

PPS must not be used to imply legal advice, guaranteed compliance or guaranteed technical control over third-party hardware.
