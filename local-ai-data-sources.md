# Local AI Data Sources & Entity Consistency

Status: mandatory framework module for local and location-dependent organisations  
Effective: 21 September 2026

## Purpose

Local AI visibility does not depend on one profile or one map provider. The framework therefore checks whether a business is represented consistently across first-party information and relevant external local-data sources.

This module belongs to **Search and Open-Web Presence** and is evaluated separately from observed AI mentions, citations or recommendations.

## Core source set

Where relevant and publicly verifiable, a full analysis checks:

1. the organisation's own website and canonical location/contact pages;
2. Schema.org / JSON-LD, especially `Organization`, `LocalBusiness`, `Place`, `PostalAddress`, `Service` and related identifiers;
3. Google Business Profile;
4. Bing Places;
5. Apple Business, including the resulting Apple Maps / Maps presence where applicable;
6. other map, POI and navigation surfaces when they are materially relevant and can be verified;
7. authoritative industry directories, destination portals, chambers, booking platforms or sector-specific listings;
8. other high-confidence external references used to corroborate identity, location, services or opening information.

No specific third-party map or POI provider is assumed to be an upstream source for an AI product unless that relationship is supported by current official evidence.

## Consistency fields

The analysis compares, where applicable:

- organisation / venue name;
- canonical website URL;
- physical address or service area;
- telephone and public contact channels;
- coordinates or mapped location;
- primary and secondary categories;
- opening hours and temporary closures;
- services, products and amenities;
- booking, reservation, enquiry or order URLs;
- identifiers, social/profile links and entity relationships;
- language and locale;
- high-impact factual claims that affect a user's decision.

## Evidence states

Every checked source or field must use an explicit evidence state:

- **verified_consistent** – observed and consistent with the authoritative source of truth;
- **verified_inconsistent** – observed but materially contradictory;
- **verified_partial** – observed but incomplete;
- **not_measured** – not checked or not technically accessible;
- **not_applicable** – not relevant to the organisation.

`not_measured` must never be converted into `missing` merely because a profile is not linked from the website.

## Quick-Check depth

The Quick-Check evaluates only structural local signals that are actually observable from the submitted website and any explicitly discoverable evidence available to the check.

It may identify:

- contact and location clarity;
- LocalBusiness/Organization structured data;
- explicit links or references to business profiles;
- obvious first-party contradictions.

It must not claim that Bing Places, Apple Business, Google Business Profile or another external listing is absent unless that external source was actually checked.

Unmeasured external sources do not reduce the Quick-Check score.

## Full-analysis depth

The full analysis performs the broader external consistency review. For local or location-dependent businesses it should, where technically and legally feasible:

- verify the core source set;
- record the checked URL or profile identifier;
- capture the observation date;
- compare high-impact fields;
- distinguish first-party truth from third-party repetition;
- document contradictions and stale information;
- prioritise corrections by likely customer and machine impact.

The report should identify which source should be corrected, not simply state that "local SEO needs improvement".

## Scoring rules

- Presence alone is not a quality signal.
- A profile receives no bonus merely for existing.
- Consistency, completeness, freshness and authority matter more than profile count.
- A verified contradiction may reduce the relevant readiness score.
- `not_measured` and `not_applicable` do not create an artificial penalty.
- Observed AI visibility remains a separate outcome measurement.

## Naming convention

Use **Apple Business** for Apple's current business-management platform. Use **Apple Maps** or **Maps presence** only when referring to the consumer-facing map surface itself.

## Reporting language

Preferred wording:

> Local source consistency is a prerequisite for reliable entity resolution. It is not proof that a specific AI system used, cited or ranked any of these sources.

The module is designed to complement, not replace, technical SEO, Local SEO, Entity SEO, AI Readability, Source Integrity, Agent Readiness or observed AI Visibility testing.
