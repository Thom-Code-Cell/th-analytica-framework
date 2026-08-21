# TH Analytica – Natural Query & AI Intent Layer

Status: optional data layer for future TH Analytica full analyses

## Purpose

The Natural Query & AI Intent Layer connects real search demand with semantic website analysis and AI-answer testing. It must never be presented as a detector for ChatGPT, Gemini, AI Overviews or other proprietary AI prompts. Google Search Console reports Google Search performance; it does not reliably identify whether a query originated from or was answered by an AI system.

The layer is therefore used to answer a narrower and defensible question:

> Which naturally phrased, decision-relevant search queries are already associated with the company, how well does the website answer them, and which query clusters should be tested further in AI systems?

## Activation status

Every full analysis records exactly one status:

### 1. GSC LIVE DATA
Use when the customer has granted authorised Google Search Console access for the analysis.

### 2. GSC EXPORT DATA
Preferred low-friction mode when no direct access is available. The customer or its agency supplies a CSV/XLSX export.

Minimum requested period: 6 months. Preferred period: 12 months.

Required fields where available:
- query
- page
- clicks
- impressions
- CTR
- average position
- country
- device
- date or date range

No Google account credentials are required.

### 3. PUBLIC INTENT MODEL
Use when no Search Console data is available.

This mode may use public website content, public search-result patterns, FAQ/PAA signals, competitor content, Google Business Profile data and public AI-answer tests to model likely natural-language intents.

Important: this is a modeled intent layer, not evidence of actual customer demand. The report must label it explicitly as such.

## Customer access and ownership check

The full analysis should record whether the customer itself has access to the following digital assets:

- Google Search Console
- Google Analytics / GA4, if used
- Google Business Profile
- Bing Webmaster Tools, if used
- Tag Manager, if used

Recommended status labels:
- Customer owner/admin
- Customer authorised user
- Agency only
- Not configured
- Unknown

A website agency may manage these systems operationally, but the customer should ideally retain its own owner/admin or equivalent access to business-critical properties.

## If GSC is controlled by an agency

The customer does not need to grant TH Analytica direct access. A data export is sufficient.

Recommended request to the agency:

"Bitte exportieren Sie aus der Google Search Console für die letzten 12 Monate die Leistungsdaten nach Suchanfrage und Seite mit Klicks, Impressionen, CTR und durchschnittlicher Position und senden Sie die Datei als CSV oder Excel. Wenn möglich, bitte zusätzlich Land und Gerät einschliessen."

## Analysis workflow

### Step 1 – Clean and classify

Separate obvious short navigational/generic queries from natural-language and decision-oriented queries.

Signals can include:
- full questions
- sentence-like searches
- comparison language
- provider-selection language
- problem/solution formulations
- location + need combinations
- high commercial or operational intent

Long query length alone is not proof of AI use and must not be treated as such.

### Step 2 – Intent and JTBD mapping

For each relevant query cluster, identify:
- situation/problem
- desired outcome
- decision stage
- requested proof or trust signal
- expected next action
- relevant service/entity

### Step 3 – Answer Coverage

Compare the query with the ranking/target page and classify:
- Green: direct and sufficient answer
- Yellow: partial or indirect answer
- Red: no clear answer
- Semantic Friction: the query reveals a different interpretation of the company than the intended positioning

### Step 4 – Prompt Opportunity Score

Score 0–100 using observable factors such as:
- natural-language structure
- business relevance
- decision/commercial intent
- impressions
- current average position
- answer gap
- semantic-positioning gap
- competitor relevance

The score is a prioritisation aid, not a prediction of AI mentions, rankings, leads or revenue.

### Step 5 – Content actions

Cluster related queries and convert them into:
- answer blocks
- FAQ additions
- JTBD sections
- service-page clarifications
- internal links
- semantic entity reinforcement
- Answer Cards / concise machine-readable summaries

Avoid creating one thin page per query.

### Step 6 – AI-system test set

When useful, take the highest-value real query clusters and convert them into controlled test prompts for current AI systems.

Measure separately:
- whether the company is mentioned
- whether the company is described correctly
- which competitors are named
- which sources are cited
- which facts are missing or wrong

These AI tests are a separate measurement layer. They must not be inferred from Search Console clicks, impressions, CTR or position.

## Core metrics

### Natural Query Share
Share of relevant queries that are sentence-like, question-like or clearly natural-language oriented.

### Answer Coverage
Share of priority natural-query clusters that the website answers directly and sufficiently.

### Semantic Alignment
How closely the demand/query language aligns with the company’s intended services, entities and positioning.

### Prompt Opportunity Score
Prioritisation score for query clusters where content, trust, structured data or AI-answer testing could create the greatest strategic value.

## Reporting rules

Every report using this layer must state the data source and confidence level.

Never state or imply:
- that a GSC query is proven to be a ChatGPT/Gemini prompt
- that zero clicks prove the answer happened in an AI box
- that GSC position proves AI recommendation visibility
- that impressions equal unique people

Always distinguish:
1. Google Search demand/performance data
2. website answer quality and semantic alignment
3. observed AI-system answer tests

## Full-analysis integration

The layer is optional and does not replace the standard TH Analytica v9.x / v9.4 MAX analysis structure.

When GSC data is available, add a dedicated section titled:

**Natural Query & AI Intent Analysis**

It should contain:
- data-access status
- date range and source
- natural-query clusters
- JTBD/intent classification
- Answer Coverage
- Semantic Alignment
- Prompt Opportunity Score
- priority content actions
- optional AI test-prompt set

When GSC data is unavailable, use **Public Intent Model** and label all conclusions as modeled rather than observed demand.

## Principle

Use real first-party search data when available. Use exports instead of requesting unnecessary account credentials. Where no first-party data exists, model intent transparently and never manufacture certainty.
