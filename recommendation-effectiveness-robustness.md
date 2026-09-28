# Recommendation Effectiveness & Robustness

Status: **Measurement module for recommendation-focused analyses and applicable Full Analyses**  
Effective: 2026-09-27

## Purpose

This module measures whether an organisation is merely present and understandable in AI systems or whether its verified strengths actually influence recommendation outcomes in relevant decision situations.

It separates:

1. **Found** – the organisation is discoverable or mentioned.
2. **Understood** – relevant facts, services, location and specialisation are reproduced correctly.
3. **Considered** – the organisation appears in a relevant shortlist or comparison set.
4. **Recommended** – the system explicitly recommends or selects the organisation for the tested need.
5. **Actionable** – a verified next step such as contact, directions, booking or request is surfaced.

These states must not be collapsed into one readiness score.

## Entity resolution and implementation state

For each response, code **name mention**, **unambiguous entity match**, **canonical or verified URL citation**, **shortlist**, **explicit recommendation**, and **verified action** as separate fields. Record approved name, spelling, product/subbrand and canonical-domain variants before measurement; keep the matching rule and exceptions versioned. A URL-only hit is not automatically a recommendation; an unlinked name mention is not a citation. Ambiguous matches require human adjudication and must not be silently counted.

Every remediation is tracked independently as `erkannt → vorgeschlagen → umgesetzt → verifiziert` with observation URL, owner, release evidence, verification date and test result. A proposal is not an implementation, and a deployed change is not a verified visibility gain. This is a TH Analytica reporting convention, not an external standard.

## Core method

Where an intervention is being evaluated, use:

**Baseline test → documented intervention → re-test → comparison**

The test set should be derived from the Positioning Foundation and Desired Query Space rather than from generic prompts.

## Measurement controls

Record the AI/search system and mode, date, language, user intent, material location context, exact prompt or controlled prompt family, retrieval mode and repetitions where relevant.

For every observation record mention, citation or named source, factual accuracy, shortlist inclusion, explicit recommendation, recommendation reason, surfaced action and contradictions or hallucinated attributes.

A claimed recommendation reason counts only when it is visible in the output and can be mapped to reliable evidence. A company attribute that exists on the website is not automatically a demonstrated recommendation driver.

Before optimisation, preserve baseline results. After changes, document exactly what changed. Do not claim causality from a before/after sequence alone where multiple material factors changed or the external system is unstable.

## Robustness

Recommendation Robustness assesses whether the observed result survives reasonable variation across paraphrased prompts, repeated runs, different dates, relevant AI/search systems, languages where applicable, nearby but distinct user intents, and source or retrieval variation.

Robustness is reported as observed test consistency, not as a hidden-model probability.

## Competitive context

When the scope includes competitors, record which alternatives are named, what reasons are given, which sources support the comparison, and whether the organisation is omitted because of a factual gap, weaker evidence, unclear fit or an unknown system decision.

Do not reverse-engineer proprietary ranking logic from output alone.

## Reporting

Recommendation-focused reports should include tested decision situations, baseline results, intervention log, re-test results, change in mention/shortlist/recommendation observations, recommendation reasons and evidence quality, cross-system and cross-prompt robustness, unresolved contradictions and the next experiment or remediation step.

## Evidence boundary

A single recommendation, customer statement, phone call or successful prompt is useful evidence of an observed event, but it is not proof of general recommendation probability or causal impact.

The framework therefore keeps structural readiness, observed AI output, recommendation effectiveness, business action and attributable business outcome as separate evidence layers.
