# TH Analytica Physical AI Governance v0.1

Status: **Experimental**  
Updated: 2026-09-16

## Direct answer

A visible QR marker can lead a person or compatible AI client to a machine-readable venue policy. It cannot universally disable cameras, microphones or AI-glasses functions. Version 0.1 therefore treats enforcement as advisory and requires transparent user notice, bounded duration and manual override.

## Purpose

The profile connects four surfaces:

1. a visible human notice at the venue;
2. an Entry QR marker;
3. an Exit QR marker;
4. a canonical HTTPS policy document.

The policy describes the issuer, canonical venue identity, zone boundary, separate rules for photography, video, audio, livestreaming, visual analysis and biometric identification, plus activation and deactivation behavior.

All implementations follow `privacy-by-design-standard.md`. Identifiable photo, video and audio capture is prohibited by default until purpose, legal basis, transparency, necessity, retention and safeguards are documented. An unclear legal basis blocks enablement and requires human review. Biometric identification remains prohibited by default.

## Compatible-client behavior

A compatible client should fetch the policy only over HTTPS, verify the issuer, show or speak the notice, request acknowledgement, apply only supported restrictions, preserve a visible override and restore its previous state after the Exit marker or maximum duration.

An arbitrary QR code must never silently change hardware state. Vendor-native support may only be reported when it has been directly tested and documented.

## Geographic anchoring

A customer implementation connects one canonical venue identifier with a structured postal address, coordinates for the public venue or publicly accessible main entrance, verified map URLs, and written building and zone boundaries. Coordinates identify the venue or entrance; indoor boundaries remain explicit descriptions connected to Entry and Exit markers.

Only public coordinates are published. Exact coordinates for patient rooms, classrooms, protected collections, staff-only areas and other sensitive zones are excluded. The on-site record retains the verified address, entrance, map profiles, marker locations, boundary descriptions, review date and responsible approver.

## Evidence labels

- **Implemented:** public schema, discovery document, demo policy, Entry and Exit states, consistency tests.
- **Experimental:** voluntary interpretation by a purpose-built compatible client.
- **Not measured:** native recognition or compliance by third-party AI-glasses assistants.
- **Not available:** universal control of arbitrary consumer devices.

## Person-level privacy complement

Location governance is complemented by the experimental **Personal Privacy Signal (PPS)**. PPS lets a compatible personal device broadcast an anonymous privacy preference without requiring a venue marker. The reference **Collective Privacy Shield** can protect the entire camera scene, including bystanders without PPS, without identifying which person sent the request.

PPS is not a universal hardware control mechanism. Native third-party support is not measured, and privacy-preserving sender authentication and anti-abuse controls remain unresolved standardisation work. See `personal-privacy-signal.md`.

## Resources

- Website: `https://th-analytica.com/physical-ai-readiness`
- Discovery: `https://th-analytica.com/.well-known/physical-ai-governance.json`
- JSON Schema: `https://th-analytica.com/schemas/physical-ai-governance-v0.1.schema.json`
- Example: `examples/hotel-zone-policy.example.json`
- Full-analysis rule: `full-analysis-physical-ai-governance.md`

## Customer implementations

Every policy must use the customer's verified venue identity, domain, responsible contact, physical boundary and current house rules. Legal validity, on-site enforcement and device-vendor support are separate assessments and must not be inferred from publication.
