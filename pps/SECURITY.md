# PPS security policy

## Reporting

Security and privacy issues that would expose users, enable tracking, weaken unlinkability, facilitate spoofing/denial of service or create misleading protection claims should be reported privately first to:

**thomas@th-analytica.com**

Do not include unnecessary personal data, production secrets or third-party credentials in a report.

## Priority areas

The PPS project treats the following as security-sensitive:

- turning rotating identifiers into persistent identifiers;
- hidden stable identifiers in payloads or telemetry;
- replay or spoofing that can create false privacy requests;
- denial-of-service against receivers;
- bypasses where an interface claims protection but capture continues unexpectedly;
- leakage of camera, microphone, location or identity data by a reference implementation;
- cloud logging that defeats the local/privacy-preserving design;
- malicious vendor extensions that silently weaken semantics.

## Draft v1.0 known limitation

The open BLE payload in Draft v1.0 is not authenticated. Spoofing, replay and abuse resistance remain unresolved design work.

Do not describe Draft v1.0 as cryptographically authenticated, tamper-proof or resistant to all denial-of-service attacks.

## Disclosure process

1. Acknowledge and triage the report.
2. Reproduce where possible without collecting unnecessary personal data.
3. Define mitigation and affected versions.
4. Coordinate disclosure when early publication would materially increase user risk.
5. Publish the fix and update the threat model or conformance requirements where relevant.

## Reference implementation principle

The ordinary public sender should request only permissions required for its documented function. Laboratory diagnostics must remain clearly separated from ordinary protection mode.

## Safety

PPS must not be designed to suppress legally required or safety-critical recording without an explicit policy decision by the responsible receiving system.
