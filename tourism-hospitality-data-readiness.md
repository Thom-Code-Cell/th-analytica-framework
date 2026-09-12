# Tourism & Hospitality Data Readiness v0.1

Status: sector module
Effective: 2026-09-12

## Purpose

This module assesses whether hotels, accommodation providers and destinations maintain a consistent, verifiable and usable representation of their offer across the tourism data ecosystem.

It incorporates relevant operational requirements described by Jean-Claude Morand and Roland Schegg in *Werden Sie für KI sichtbar: Die Schlüssel zur semantischen Optimierung und Generative Engine Optimisation (GEO) für Hotels* (version 0.4.6, 3 February 2026). The source informs this module; it is not adopted as a ranking specification or proof of causal impact.

## Applicability

Every full analysis records one state:

- **applicable:** hotel, accommodation provider, destination, DMO or tourism offer;
- **not applicable:** no material tourism or hospitality offer;
- **open:** evidence is insufficient and requires human review.

Only applicable cases are scored. Quick Checks may report a reduced, non-scored screening.

## Required evidence model

Each finding must record:

- observed surface and URL or system name;
- field or claim tested;
- observed value and capture time;
- evidence class: first-party, platform-managed, third-party or modeled;
- status: confirmed, conflicting, missing, stale, inaccessible or not applicable;
- responsible owner and recommended correction path where known.

Absence from an inaccessible platform must be reported as **not observed**, not **missing**. Information copied across platforms is not independent corroboration unless provenance supports that conclusion.

## Control family A: Canonical entity and property identity

Verify:

- official name, alternate names and operator/brand relationship;
- canonical URL and stable identifiers where legitimately available;
- full postal address, telephone and primary contact details;
- coordinates and map placement;
- accommodation/property type and category;
- same-entity links that are relevant and supported;
- consistency between visible content and machine-readable representations.

Entity identity is evaluated separately from visibility or recommendation outcomes.

## Control family B: Hospitality Attribute Inventory

Maintain and test a field-level inventory covering, where applicable:

- property and accommodation type;
- room or unit categories, occupancy, beds and capacity;
- amenities and room features;
- food and beverage services;
- wellness, pool, sport and leisure facilities;
- accessibility features, including which spaces or units they apply to;
- family, pet, smoking and other guest policies;
- check-in, check-out, reception and service hours;
- parking, shuttle and public-transport information;
- location, coordinates, contained places and nearby access points;
- events and bookable experiences;
- images and the claims they visibly support;
- booking, enquiry and cancellation paths;
- prices and availability only with source, currency, timestamp and validity context.

The inventory is a governance object, not merely a one-time spreadsheet. Each material field should have an accountable owner, authoritative internal source, last verification date and update trigger.

## Control family C: Cross-surface consistency

Compare the inventory against all relevant and accessible surfaces:

1. official website and booking engine;
2. visible page content and JSON-LD;
3. Google Business Profile and relevant maps;
4. OTAs and metasearch platforms;
5. DMO or Tourism Information Systems (TIS);
6. national or sector data hubs such as discover.swiss/AccommoDataHub where applicable;
7. relevant directories and knowledge sources.

The analysis must identify contradictions at field level. Name, address and telephone consistency is necessary but insufficient; room features, accessibility, facilities, policies, opening hours, category, location and booking facts also require review.

## Control family D: Structured representation

Verify that structured data:

- uses the most specific supported type without inventing facts;
- has stable `@id` relationships for the property, organisation, rooms, offers, places and events where appropriate;
- matches visible content;
- distinguishes the operator or organisation from the physical property;
- represents amenities and accessibility at the correct level;
- does not publish stale prices, aggregate ratings or availability;
- validates syntactically and does not depend on unsupported properties for critical meaning.

Schema.org or JSON-LD is a controlled semantic signal. It does not guarantee indexing, retrieval, citation, recommendation or booking.

## Control family E: Freshness and operating process

Verify:

- stable and dynamic fields are distinguished;
- an owner and update cadence exist for every material data family;
- seasonal and exceptional opening hours can override defaults;
- prices, packages, events and availability include valid time context;
- corrections propagate to downstream systems;
- conflicts and failed feeds are monitored;
- management, operations and technical roles are explicit.

Training or organisational capability may be recorded as an implementation dependency. Legal compliance must be assessed against the organisation's actual jurisdiction and role, not inferred from a generic statement in a source document.

## Control family F: Reputation and external corroboration

Review:

- rating and review presence across relevant platforms;
- consistency between claimed and platform-observed ratings;
- recurring sentiment themes with sample size and time window;
- management responses and material unresolved complaints;
- credible third-party descriptions and citations;
- source concentration and duplicated platform data.

Sentiment is evidence about observed guest feedback, not proof of service quality or future recommendation.

## Control family G: Agent and transaction readiness

Assess separately from semantic markup:

- whether availability and prices can be obtained from an authoritative live source;
- whether booking, enquiry, cancellation or modification actions are clearly defined;
- authentication, authorisation, payment and confirmation boundaries;
- human approval and fallback for consequential actions;
- rate limits, error handling and auditability;
- whether policies and terms are available before commitment.

A `potentialAction` declaration alone does not establish that an action works. Transaction claims require a safe, authorised end-to-end test or must remain unverified.

## Control family H: Physical venue linkage

Where the organisation operates a relevant venue, connect this module to Physical AI Readiness & Visual Governance. Verify that the canonical property identity, coordinates, contained spaces and public rules resolve to the same venue. Detailed visual and sensor governance remains governed by `physical-ai-governance.md`.

## Reporting

The full analysis reports:

- applicability state;
- attribute coverage by data family;
- cross-surface conflict register;
- freshness and ownership gaps;
- structured-data mismatches;
- TIS/DMO/OTA distribution gaps;
- agent/transaction readiness separately from semantic readiness;
- prioritised corrections with responsible role.

Do not compress the result into a claim that a high score causes AI recommendation. When an overall sector score is used, publish the weighting, evidence coverage and treatment of inaccessible surfaces.

## Source note

Primary incorporated source:

Morand, Jean-Claude, and Roland Schegg. *Werden Sie für KI sichtbar: Die Schlüssel zur semantischen Optimierung und Generative Engine Optimisation (GEO) für Hotels*. Version 0.4.6, 3 February 2026, 109 pages. Relevant themes include management/operations/webmaster responsibilities (pp. 26-32), attribute inventories and structured data (pp. 30-46), cross-source consistency and TIS workflows (pp. 56-60), and tourism-system/schema references (appendices).

TH Analytica applies an evidence-first interpretation: the document's examples and simulations are not treated as measured ranking effects, and no universal recommendation uplift is inferred from markup alone.
