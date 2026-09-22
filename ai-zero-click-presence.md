# AI Zero-Click Presence & Direct Action Measurement

Status: TH Analytica Framework module  
Version: 1.0  
Updated: 2026-09-22

## Purpose

AI Zero-Click Presence measures what can be observed in an AI-assisted answer or action surface when a user can obtain useful company information, a recommendation or a verified next action without first opening the organisation's website.

The module does **not** infer AI presence from falling website traffic, low click-through rate or Search Console zero-click patterns. Search traffic and AI-output observations remain separate evidence classes.

## Core distinction

The framework separates four states:

1. **AI Answer Presence** – the organisation is mentioned, cited or otherwise unambiguously represented in a tested AI output.
2. **Zero-Click Capability** – the tested AI surface contains enough verified information to satisfy the tested intent or exposes a verified next action without requiring a first-party website visit.
3. **Direct Action Readiness** – authoritative contact, directions, booking, request or transaction paths are clearly published and machine-interpretable. This is structural readiness and is not proof that a third-party AI product exposes or executes the action.
4. **Observed Zero-Click Outcome** – a real enquiry, call, direction request, booking, reservation or other business action is independently attributable to an AI-assisted interaction without a first-party website visit.

These states must never be collapsed into one score.

## Mandatory evidence fields for controlled AI-output tests

For each tested prompt/system record, capture where observable:

- system and product mode
- prompt and intent category
- locale and timestamp
- organisation mentioned: yes/no
- first-party URL cited: yes/no
- explicit recommendation: yes/no
- factual accuracy: accurate / partly accurate / inaccurate
- zero-click capable: yes/no/not measurable
- surfaced action type: none / phone / directions / email / form / booking / reservation / quote / purchase / other
- action target or endpoint where visible
- source URLs or source family where supplied
- archived response reference
- human reviewer notes

## Metrics

When the sample is defined and repeatable, report:

- **AI Answer Presence Rate** = outputs with an unambiguous organisation presence / eligible tested outputs
- **Citation Rate** = outputs citing an authoritative first-party URL / eligible tested outputs
- **Explicit Recommendation Rate** = outputs explicitly recommending the organisation / eligible tested outputs
- **Zero-Click Capability Rate** = outputs classified as zero-click capable / eligible tested outputs
- **Direct-Action Surface Rate** = outputs exposing at least one verified next action / eligible tested outputs
- **Factual Accuracy Rate** = accurate outputs / reviewed outputs

Report n/N with the rate. For binary rates in formal benchmarks, use a 95% Wilson interval where the protocol calls for confidence intervals.

Observed Zero-Click Outcomes are reported separately as event counts or conversion measures from an identified attribution method. They are not estimated from the output-test rates above.

## Attribution boundary

A traffic decline, a low CTR or a zero-click search pattern is **not** evidence that an AI system answered the user's question or caused a business outcome.

Examples of acceptable outcome evidence can include:

- a customer explicitly reporting that an AI system recommended the business;
- a booking or enquiry flow carrying a reliable AI-assistant referral or campaign marker;
- a controlled test in which the action path and completion are observed and authorised;
- another documented attribution method with known limitations.

Anecdotal evidence may be documented as a case observation, but it must not be converted into a general conversion rate without a defined denominator.

## Quick-Check rule

The Quick-Check may assess **Zero-Click Readiness signals** such as clear entity data, contact paths, booking/request routes and structured action information when these are publicly observable.

The Quick-Check does **not** claim actual AI Zero-Click Presence, Zero-Click Capability Rate or observed zero-click conversions unless external AI outputs and business outcomes were separately tested. These fields remain `not_measured`.

## Full Analysis rule

Every Full Analysis must include an **AI Zero-Click Presence & Direct Action** result.

- If controlled AI-output testing is performed, report the observed metrics and sample.
- If direct business-outcome attribution data is available, report it separately with its attribution method.
- If either evidence class is absent, mark it `not_measured` rather than inferring a result.
- Keep structural Direct Action Readiness separate from observed third-party AI behaviour.

## Relationship to other framework modules

This module is cross-layer:

- Dimension 2 supplies search/open-web context but does not prove AI output.
- Dimensions 3–6 support entity clarity, evidence and answer quality.
- Dimension 7 evaluates Agent Readiness and Governance for controlled actions.
- Dimension 8 evaluates observed AI visibility, source concentration, resilience and zero-click answer/action presence.

## Interpretation

The desired maturity path is:

**found → understood → present in the answer → recommended where appropriate → actionable without unnecessary friction → attributed business outcome where evidence exists**

No stage guarantees the next one.
