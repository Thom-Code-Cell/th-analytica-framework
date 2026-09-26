# PPS governance

Status: project governance policy  
Maintainer: TH Analytica / Thomas Hullin

## Purpose

PPS is intended to be an interoperable, privacy-preserving signal that can be evaluated and implemented by device manufacturers, operating-system providers and application developers without requiring identity disclosure by the person expressing the privacy preference.

Governance exists to prevent fragmentation, misleading compatibility claims, silent weakening of privacy properties and vendor-specific capture of the protocol.

## Roles

**Maintainer**  
TH Analytica maintains the canonical specification, version history, governance documents and official conformance rules.

**Contributors**  
Anyone may propose corrections, tests, threat-model improvements or protocol changes through the public repository.

**Implementers**  
Manufacturers and developers may build implementations subject to the applicable licence terms and trademark-use policy.

**Reviewers**  
Security, privacy, accessibility and interoperability experts may provide independent review. Review does not automatically imply endorsement.

## Change process

1. Non-sensitive proposals should be documented in a GitHub issue or pull request.
2. The proposal must state the problem, privacy impact, interoperability impact and backward-compatibility impact.
3. Breaking wire-format or semantic changes require a major protocol-version change.
4. Security-sensitive details may be handled privately first under [SECURITY.md](SECURITY.md).
5. Accepted changes are recorded in Git history and reflected in the canonical specification and version documentation.

## Decision principles

Changes should prefer:

- data minimisation;
- unlinkability;
- local processing;
- interoperability;
- explicit limitations;
- least privilege;
- safe failure;
- compatibility with lawful safety and emergency exceptions;
- no identity requirement where scene-level protection can achieve the purpose.

A proposal should not be accepted merely because it benefits one vendor if it creates avoidable lock-in or weakens the privacy model.

## Extensions

Vendor-specific extensions must be clearly namespaced and must not silently redefine official PPS fields or semantics.

An extension may be documented as "based on PPS" or "PPS extension" when factually accurate. It must not be presented as part of the official PPS core unless accepted into the canonical specification.

## Official status

The following are separate concepts:

- implementing the public protocol;
- passing the official conformance requirements;
- receiving permission to use an official PPS compatibility badge or other protected project branding.

Technical implementation alone does not imply TH Analytica endorsement, certification or partnership.

## Conflicts and independence

Commercial collaboration with an implementer does not give that implementer unilateral control of PPS. Material protocol changes remain subject to the same documented governance process.

## Legal and safety boundary

PPS is a technical and governance project. It is not legal advice and does not itself create a guaranteed legal right to stop recording or processing. Implementers remain responsible for applicable law, safety requirements and product behavior.
