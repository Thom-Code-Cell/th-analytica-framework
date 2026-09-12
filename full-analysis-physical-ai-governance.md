# Physical AI Governance in every full analysis

Status: **Mandatory applicability gate**  
Effective: 2026-09-10

## Rule

Every TH Analytica full analysis records exactly one applicability state for Physical AI Governance:

- **applicable:** the organisation operates a customer, patient, guest, visitor or staff venue where visual or audio recording rules matter;
- **not applicable:** the analysed offer has no relevant venue operated or controlled by the organisation where Physical AI Governance rules would apply;
- **open:** the available evidence is insufficient and a human reviewer must decide before delivery.

Only **applicable** cases receive a detailed assessment. **Not applicable** and **open** cases are excluded from the overall score.

## Required checks for an applicable venue

1. canonical venue identifier, structured address, public-entrance coordinates, map profiles and source consistency;
2. public house rules and responsible issuer;
3. human-readable notice at each relevant boundary;
4. separate policies for photo, video, audio, livestream, visual analysis and biometric identification;
5. HTTPS policy with a stable policy and zone identifier;
6. visible Entry and Exit QR markers;
7. explicit acknowledgement, manual override and maximum duration;
8. validation of QR destination, JSON syntax, schema conformance and stale-policy behavior;
9. device or client support reported by evidence level, never by assumption;
10. legal and operational review recorded separately from technical readiness;
11. privacy check confirming that only public coordinates are published and no sensitive indoor location is exposed.

## Reporting language

The report must state that the marker communicates rules but does not universally control third-party devices. Terms such as *blocks all AI glasses*, *automatically disables recording* or *guarantees compliance* are prohibited unless a named device and client have been directly tested and the scope is precisely documented.
