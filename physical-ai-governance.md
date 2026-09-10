# TH Analytica Physical AI Governance v0.1

Status: **Experimental**  
Updated: 2026-09-10

## Direct answer

A visible QR marker can lead a person or compatible AI client to a machine-readable venue policy. It cannot universally disable cameras, microphones or AI-glasses functions. Version 0.1 therefore treats enforcement as advisory and requires transparent user notice, bounded duration and manual override.

## Purpose

The profile connects four surfaces:

1. a visible human notice at the venue;
2. an Entry QR marker;
3. an Exit QR marker;
4. a canonical HTTPS policy document.

The policy describes the issuer, canonical venue identity, zone boundary, separate rules for photography, video, audio, livestreaming, visual analysis and biometric identification, plus activation and deactivation behavior.

## Compatible-client behavior

A compatible client should fetch the policy only over HTTPS, verify the issuer, show or speak the notice, request acknowledgement, apply only supported restrictions, preserve a visible override and restore its previous state after the Exit marker or maximum duration.

An arbitrary QR code must never silently change hardware state. Vendor-native support may only be reported when it has been directly tested and documented.

## Evidence labels

- **Implemented:** public schema, discovery document, demo policy, Entry and Exit states, consistency tests.
- **Experimental:** voluntary interpretation by a purpose-built compatible client.
- **Not measured:** native recognition or compliance by third-party AI-glasses assistants.
- **Not available:** universal control of arbitrary consumer devices.

## Resources

- Website: `https://th-analytica.com/physical-ai-readiness`
- Discovery: `https://th-analytica.com/.well-known/physical-ai-governance.json`
- JSON Schema: `https://th-analytica.com/schemas/physical-ai-governance-v0.1.schema.json`
- Example: `examples/hotel-zone-policy.example.json`
- Full-analysis rule: `full-analysis-physical-ai-governance.md`

## Customer implementations

Every policy must use the customer's verified venue identity, domain, responsible contact, physical boundary and current house rules. Legal validity, on-site enforcement and device-vendor support are separate assessments and must not be inferred from publication.
