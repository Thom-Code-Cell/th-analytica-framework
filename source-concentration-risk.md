# Source Concentration & AI Visibility Resilience

## Purpose

AI visibility is not treated as a single-platform state. Retrieval and citation behaviour can change independently across ChatGPT, Google AI Overviews, Gemini, Copilot, Perplexity and other systems. A company can therefore remain technically accessible while losing visibility because one system changes its source selection, ranking or retrieval behaviour.

TH Analytica full analyses should therefore measure not only whether a company is mentioned or cited, but also how dependent that visibility is on individual source families and AI systems.

This layer measures observable output behaviour only. It must not be presented as evidence of proprietary model internals, training data, hidden ranking factors or contractual access arrangements.

---

## Required reporting dimensions

### 1. Source Family Distribution

For every controlled AI-answer test where sources or citations are visible, assign each cited or clearly relied-on source to a source family, for example:

- First-party website
- Google Business Profile / Google local surfaces
- Bing / Microsoft local surfaces
- LinkedIn or other professional networks
- Reddit / forums / community platforms
- Review platforms
- Industry directories / associations
- News / editorial media
- Marketplaces / booking platforms
- Public authorities / registries
- Other third-party sources

The report must distinguish observed citations from inferred influence. If a system does not expose sources, no source share may be invented.

### 2. Top Source Dependency

Record the share of observed citations attributable to the single largest source family.

Suggested interpretation:

- Green: below 35%
- Yellow: 35-49%
- Orange: 50-64%
- Red: 65% or more

These thresholds are operational risk indicators, not claims about platform ranking algorithms.

### 3. Source Diversity Score

Measure how broadly the company's observed AI visibility is distributed across independent source families.

A high score requires multiple meaningful source families, not merely many URLs from the same platform or domain group.

### 4. Source Concentration Index

Where enough observations exist, calculate a concentration measure from source-family shares. TH Analytica may use a Herfindahl-Hirschman-style index or equivalent normalized concentration score.

The report must show the underlying sample size. Small samples must be marked as low-confidence.

### 5. System Dependency

Measure how much of the positive visibility result depends on one AI/search system.

The analysis should compare, where operationally possible:

- ChatGPT / ChatGPT Search
- Google AI Overviews and/or Gemini
- Microsoft Copilot
- Perplexity
- additional relevant systems for the customer or market

A company that performs strongly in one system but poorly in the others must not receive an undifferentiated 'high AI visibility' conclusion.

### 6. First-Party Resilience

Record whether the company's own website and controlled machine-readable assets are directly discoverable, understandable and citeable independently of third-party platforms.

This includes, where applicable:

- indexable service and entity pages
- clear Organization / LocalBusiness / Product / Service / Event / JobPosting data
- canonical consistency
- AI/search crawler accessibility
- entity consistency
- answer-ready content
- agent-readable action paths

### 7. Volatility / Re-Test Status

For recurring measurements, compare source distribution and system visibility against the previous measurement.

Flag:

- major source-family loss
- major system-specific visibility loss
- rapid concentration increase
- disappearance of a previously dominant third-party source
- recovery or diversification after corrective work

A single measurement is a snapshot. Trend claims require repeated measurements.

---

## Required full-analysis output

Future full analyses should include a section titled **Source Concentration & AI Visibility Resilience** containing at minimum:

1. AI systems tested
2. number of prompts / answer tests
3. number of source-bearing answers
4. source-family distribution
5. largest source dependency
6. source diversity assessment
7. system dependency assessment
8. first-party resilience assessment
9. concentration risk status: Green / Yellow / Orange / Red
10. concrete diversification actions

Recommended visualisations:

- source-family share bar chart
- system-by-system visibility matrix
- concentration risk traffic light
- before/after trend when a prior measurement exists

---

## Interpretation rules

Do not conclude that a source has been 'blocked', 'penalised' or 'removed from an AI model' solely because citations decline.

Possible explanations can include retrieval changes, source-selection changes, query rewriting, ranking changes, crawling restrictions, licensing/access changes, measurement effects, product changes or normal sampling variance.

Robots.txt must be evaluated separately for relevant crawler identities. Training crawlers, search/retrieval crawlers and user-triggered fetchers must not be treated as interchangeable.

---

## Strategic objective

The optimisation goal is not maximum dependence on one high-performing platform. The goal is resilient AI visibility supported by:

- strong first-party information
- consistent entity signals
- diversified authoritative third-party confirmation
- multi-system measurability
- repeatable monitoring

This reduces the risk that a single platform, community, search provider or retrieval-policy change causes a disproportionate loss of discoverability.
