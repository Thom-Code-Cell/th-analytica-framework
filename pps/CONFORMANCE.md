# PPS conformance

Status: Draft conformance framework for PPS Draft v1.0

## Claim levels

### 1. PPS implementation

A developer may factually state that a product "implements the PPS protocol" only when it implements the referenced protocol version and the statement is not misleading.

This is a descriptive implementation claim, not certification.

### 2. PPS Conformance Candidate

An implementation may be submitted or documented as a conformance candidate when it has a reproducible test record against the official requirements below.

### 3. PPS Compatible

"PPS Compatible" is reserved by the official project for implementations that have passed the applicable official conformance process and have explicit permission to use that designation or badge.

**No implementation should claim official PPS certification solely because it can parse or transmit the BLE payload.**

Until TH Analytica publishes an operational conformance registry, there is no official public certification registry.

## Sender requirements for Draft v1.0

A conforming sender must demonstrate:

1. supported protocol version is encoded correctly;
2. privacy level and DENY flags match the claimed policy;
3. reserved fields are handled as specified;
4. the rotating token changes at the documented interval or faster when required by a later version;
5. the rotating token has no semantic identity meaning;
6. no name, email address, telephone number or GPS coordinate is encoded in the PPS payload;
7. the implementation does not intentionally turn the rotating token into a stable person identifier;
8. the user is not told that protection is active when BLE broadcast has failed;
9. diagnostic behavior is separated from ordinary protection behavior;
10. documentation accurately states the implementation's limits.

## Receiver requirements when receiver support is claimed

A receiver must demonstrate:

1. validation of protocol version and payload length;
2. safe handling of unknown versions and unknown flags;
3. no persistent identity is created from rotating tokens;
4. the receiver applies only behavior it actually supports and documents;
5. exceptions for safety, law or explicit authorisation are documented;
6. ordinary behavior is restored predictably when the request no longer applies;
7. logs are minimised;
8. no claim of Collective Privacy Shield is made unless scene-level protection is actually implemented.

## Security limitation of Draft v1.0

Draft v1.0 does not solve privacy-preserving sender authentication. A conforming implementation must not represent the current open BLE signal as cryptographically authenticated or immune to spoofing, replay or denial-of-service.

## Evidence bundle

A conformance record should include:

- product and build identifier;
- PPS protocol version;
- test date;
- test-suite version;
- sender and/or receiver role;
- test results;
- known exceptions;
- build or release hash where available;
- contact for security reports.

## Interoperability tests

At minimum, interoperability testing should include:

- valid payload acceptance;
- malformed payload rejection;
- unknown-version behavior;
- token rotation;
- repeated discovery;
- signal disappearance and recovery;
- conflicting nearby signals;
- receiver restart;
- sender restart;
- user-visible failure behavior.

## No legal certification

Technical conformance does not certify compliance with Swiss, EU or other privacy law and must not be marketed as legal approval.
