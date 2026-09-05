# Physical AI Governance & Agent Readiness

## Purpose

This module extends the TH Analytica Framework from digital assets and agent-facing workflows into physical places where AI-capable devices may sense, record, analyse, transmit or act.

Examples include swimming pools, hotels, hospitals, care facilities, schools, offices, factories, museums, event venues, public authorities and other controlled spaces.

The module does not assume that a machine-readable policy can technically disable a third-party device. Policy communication and technical enforcement are separate layers. Enforcement depends on device, operating-system, network, vendor and legal support.

## Core model

Physical AI Governance is assessed through five linked layers:

**Policy → Context → Enforcement → Responsibility → Audit**

### 1. Policy
Define what is allowed, restricted or prohibited.

Typical controls:
- image capture
- video recording
- audio recording
- facial or biometric recognition
- local analysis
- cloud processing or upload
- data retention
- data sharing
- use for model training
- autonomous actions by agents or devices
- actions requiring explicit human approval

### 2. Context
Rules should be bound to a place, zone, time or operational situation rather than expressed only as general device bans.

Examples:
- public pool area vs changing room
- hotel lobby vs guest room
- public museum gallery vs conservation area
- office reception vs confidential meeting room
- production floor vs public visitor area

A rule should answer: **What may this system do here, now and in this context?**

### 3. Enforcement
The framework distinguishes three maturity levels:

1. **Communicated** – the rule is visible to humans and/or machine-readable.
2. **Assisted** – compatible devices can warn, request confirmation or alter available actions.
3. **Enforced** – a supported technical control can block or constrain the action.

Potential delivery mechanisms may include:
- public policy files
- QR codes
- NFC
- Bluetooth beacons
- local network discovery
- managed-device policies
- access-control or identity systems
- vendor-specific APIs

No mechanism should be described as universally enforceable without evidence of compatible device support.

### 4. Responsibility
Every rule needs a clearly accountable owner.

The assessment should record:
- who defines the policy
- who can approve exceptions
- who can change rules
- who is responsible for technical controls
- who handles incidents or violations
- which legal, contractual or internal policy basis applies

### 5. Audit
Where technically and legally appropriate, the system should support evidence of what happened.

Possible evidence:
- policy version and timestamp
- active zone or context
- approval or exception event
- attempted or blocked action
- identity or role involved, where permitted
- data-processing event metadata
- incident record

Auditability must respect data minimisation, privacy and applicable law. The framework does not recommend creating new surveillance merely to prove compliance.

## Digital house rules

TH Analytica uses **digital house rules** as a descriptive concept for machine-readable, context-specific usage rules for physical places.

A digital house rule should state, where relevant:
- place or zone identifier
- permitted capabilities
- restricted capabilities
- prohibited capabilities
- approval requirements
- applicable time or conditions
- policy owner
- version
- effective date
- contact or escalation path

This is a framework concept, not a claim that a universal industry standard currently exists.

## Example: swimming facility

A swimming facility could define:
- camera use permitted in designated public areas
- no recording in changing rooms or showers
- no facial recognition
- no continuous audio capture
- no use of recordings for AI training
- explicit approval required for exceptional professional recording

The same model can be adapted to other sectors.

## Assessment questions

A full analysis may ask:

1. Which AI-capable devices or agents are relevant to this place?
2. Which physical zones have materially different risk or privacy requirements?
3. What may be sensed, recorded, analysed, retained, transmitted or acted upon?
4. Which actions require approval?
5. Are rules available only to humans, or also in machine-readable form?
6. Can compatible systems technically enforce any of the rules?
7. What happens when enforcement is not technically possible?
8. Who owns the rule and exception process?
9. Can material events be audited without unnecessary surveillance?
10. Are policy, technical controls and real-world operations aligned?

## Reporting

Physical AI Governance should be reported separately from general AI Visibility.

Recommended reporting blocks:
- Policy completeness
- Context / zoning clarity
- Enforcement maturity
- Responsibility and approval model
- Auditability
- Implementation gaps
- Evidence and limitations

A high readiness score does not mean that every third-party device will comply. Reports must state the difference between declared policy, supported controls and verified enforcement.
