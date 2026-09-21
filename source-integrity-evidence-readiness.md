# Source Integrity & Evidence Readiness

Version: 1.0  
Effective date: 21 September 2026  
Maintainer: Thomas Hullin / TH Analytica

## Purpose

This mandatory full-analysis module separates two questions that must not be conflated:

1. **Evidence Readiness**: Are important company claims structured so they can be checked against clear, current and authoritative evidence?
2. **AI Source Verification**: In a documented external AI answer, which source was actually named or linked, does that source exist, and does it support the concrete statement made?

The module improves auditability and reduces the risk of treating plausible-looking citations as proof. It does not expose proprietary model internals and does not claim to know hidden retrieval, training or ranking behaviour.

## Evidence Readiness

Evidence Readiness is a structural diagnostic. It reviews whether material business facts have a clear source of truth and whether visible and machine-readable representations agree.

Typical controls include:

- canonical first-party source for core facts;
- consistent company, service, location, price, opening-hour and contact information;
- visible author and update date where editorial responsibility matters;
- structured data parity with visible content;
- internal evidence paths for material claims;
- distinction between primary and secondary sources;
- freshness and ownership of critical information;
- explicit evidence labels where a claim is observed, attributed, hypothetical or not measured.

The automated full-analysis implementation may report a dedicated **Evidence Readiness score** derived from deterministic website-readiness signals. This score is a diagnostic subscore only. It must not be represented as observed external AI source quality.

## AI Source Verification

A source-bearing AI answer is only considered verified when the analysis records enough context to reproduce and inspect the observation.

For each tested answer, record at minimum:

- AI system or product;
- prompt or question;
- date and relevant locale/language;
- relevant mode or settings where known;
- answer or material claim;
- cited, named or linked source;
- whether the source exists and is identifiable;
- whether the source actually supports the concrete claim;
- freshness or relevant publication/update date;
- first-party or third-party status;
- contradictions with canonical sources;
- verification result and reviewer note.

A source title, domain or topic that merely looks plausible is not sufficient evidence.

## Standard sampling rule

The standard full-analysis depth prioritises **10 to 15 business-critical answers or claims** for source verification.

This is intentionally different from mechanically verifying every prompt across every tested system. The goal is to spend verification effort on claims that could materially affect customer decisions, trust, contact, booking, purchasing, eligibility, pricing, location, opening hours, qualifications or safety.

A broader all-prompt/all-system verification may be commissioned separately.

## Verification states

Use the following states:

- **verified_support**: source exists and supports the concrete claim;
- **partial_support**: source exists but supports only part of the claim;
- **unsupported**: source exists but does not support the claim;
- **source_not_found**: cited or named source cannot be verified;
- **stale_or_conflicting**: source exists but is outdated or conflicts with a higher-authority canonical source;
- **not_measured**: no source-level verification was performed.

Do not infer a replacement source when the system cites a non-existent or non-supporting source.

## Reporting rules

Every full analysis must:

1. report Evidence Readiness separately from external AI Source Verification;
2. disclose the Evidence Readiness scoring method;
3. state which AI systems and prompts were actually tested;
4. keep untested systems and claims as **not measured**;
5. show material contradictions rather than hiding negative results;
6. distinguish first-party evidence from third-party corroboration;
7. avoid claims about proprietary retrieval, model training or ranking internals;
8. retain enough evidence for human review.

## Relationship to other modules

This module complements:

- Evidence-First Content and Citation Readiness;
- Trust Signals;
- AI Visibility and AI Understanding measurement;
- Source Concentration & AI Visibility Resilience;
- AI Output & Liability Readiness;
- Agent Readiness and Agent Governance.

The recommended maturity path is:

**found → understood → evidenced → source-verified → recommended where appropriate → actionable within governance**.
