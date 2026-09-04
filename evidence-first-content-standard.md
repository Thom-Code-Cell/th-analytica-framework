# Evidence-First Content and Citation Readiness Standard

Version: 1.0
Effective date: 4 September 2026
Maintainer: Thomas Hullin / TH Analytica

## Purpose

This module defines how the TH Analytica Framework evaluates and produces indexable knowledge, service and case-study content. It combines answer-first writing, semantic clarity, first-party evidence, appropriate structured data and explicit measurement boundaries.

The standard improves the conditions for retrieval and reliable interpretation. It does not guarantee crawling, indexing, ranking, model training, citation, recommendation, leads or revenue.

## Core rule

One page should resolve one primary user question or decision. The first substantive paragraph should answer that question in language that remains understandable when quoted without the rest of the page.

A useful target for the initial answer is 40 to 80 words. This is guidance, not a ranking formula.

## Required controls

### 1. One primary intent

Each indexable page declares one primary user question or decision. Related follow-up questions may appear as sections. Closely related queries should be clustered rather than turned into many thin pages.

### 2. Answer first

The first substantive paragraph gives a direct answer before background, process or promotion. It identifies the subject, scope and material limitation.

### 3. Question-led sections where useful

H2 headings should reflect real follow-up questions when that improves scanning and passage-level understanding. Descriptive headings remain acceptable when clearer. Mechanical question formatting is not a quality signal.

### 4. Entity clarity

Every important organization, person, service, place, product and method is named consistently and defined in context. Name-dropping is not evidence. Each entity must contribute to the answer, relationship model or proof.

### 5. Evidence before claims

Material claims require a primary source, a reproducible first-party measurement or an explicit evidence label.

Use these labels:

- Implemented: the change, page, file or configuration can be inspected.
- Observed: a defined measurement changed during the stated period.
- Attributed: a suitable comparison or experimental design supports causality.
- Hypothesis: the relationship is plausible but not established.
- Not measured: no reproducible outcome measurement is available.

Observed sequence is not attributed impact.

### 6. Numbers with context

There is no required number density. Every material number states its source, period and method. Rates provide numerator and denominator where available. Missing data and relevant confounders are disclosed.

### 7. Original contribution

Prefer first-party datasets, documented cases, transparent experiments and clearly defined methods over paraphrased commodity content. Original material must still disclose method and limitations.

### 8. Semantic HTML and structured data

Use one H1, logical heading hierarchy, paragraphs, lists, tables and links according to meaning. JSON-LD must match visible content and use the appropriate Schema.org type.

Structured data supports interpretation. It is not proof of ranking or AI citation.

### 9. Trust and responsibility

Editorial pages show author, publication date, modification date and responsible organization. Case studies identify the customer or subject, intervention, evidence source and measurement boundary.

### 10. Internal evidence paths

Information pages link to supporting sources, applicable methodology, documented cases and one sensible next step. Commercial pages must not borrow certainty from informational content.

### 11. Human and machine parity

Prerendered, no-JavaScript and machine-readable representations communicate the same material facts and limitations as the human-facing page. Hidden crawler-only claims are prohibited.

### 12. Measurement separation

Keep these layers separate:

1. Search performance: impressions, clicks, CTR and average position from a named search product.
2. AI output: mention, citation, factual accuracy, shortlist position and explicit recommendation from controlled tests.
3. Business action: enquiries, bookings, sales or other conversions from identified data.
4. Governance and agent readiness: allowed actions, restrictions, approval steps and technical availability.

An internal readiness score is not external AI visibility. Search Console data does not identify ChatGPT, Gemini, Perplexity or AI Overview output.

## What this standard rejects

- guaranteed rankings, citations, recommendations or leads;
- invented ranking factors or claims about proprietary model internals;
- arbitrary requirements such as a fixed number of statistics per word count;
- treating llms.txt, ai.txt or proprietary JSON files as universal standards;
- treating schema presence as proof of retrieval;
- presenting correlation as causation;
- self-authored best-provider lists as independent evidence;
- scaled thin pages created only to capture query variants.

## Page template

### Primary question

State the exact user question or decision.

### Direct answer

Answer in 40 to 80 words, including scope and the most important limitation.

### Entity definition

Name the organization, person, service, place or method and explain the relevant relationship.

### Evidence

Provide the primary source or first-party observation. State date range, method and limitations.

### Follow-up questions

Use only the questions required to complete the user decision.

### Measurement boundary

State what the evidence proves and what it does not prove.

### Next step

Link to one relevant method, case, tool or human-approved action.

## Audit checklist

Score each item as Pass, Partial, Fail or Not applicable:

- one primary intent;
- direct answer first;
- useful question-led structure;
- entity clarity;
- source or evidence label for material claims;
- number provenance;
- original contribution;
- semantic HTML;
- visible author and dates;
- structured data parity;
- internal evidence path;
- human and machine parity;
- measurement separation;
- no unsupported causal or guarantee language.

A page with a failed evidence, parity or guarantee control is not publication-ready.

## Relationship to other modules

This standard complements:

- the Natural Query and AI Intent Layer, which identifies observed or modelled demand;
- the Source Concentration and AI Visibility Resilience module, which evaluates dependence on source families and systems;
- Agent Readiness and Governance, which defines permitted actions and approval boundaries;
- the Case Study Evidence Standard used for public outcome reporting.

## Reference implementation

The current reference implementation is https://th-analytica.com/ai-visibility.
