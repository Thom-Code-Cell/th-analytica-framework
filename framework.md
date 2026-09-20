# TH Analytica Framework Methodology

The TH Analytica Framework assesses observable website signals that can support technical access, retrieval and reliable interpretation by search and AI-assisted systems.

It complements traditional SEO analysis with semantic clarity, machine-readable context, open-web presence, governance, agent-readiness and AI-visibility resilience checks. It cannot observe proprietary model internals or guarantee a downstream result.

---

# Framework Dimensions

## 1 Technical Foundation
Technical stability of the website, accessibility and crawlability.

## 2 Search and Open-Web Presence
Presence in search engines, public web corpora and consistent external sources. A Common Crawl record is evidence of corpus presence only; it does not prove model training or live retrieval.

## 3 Semantic Clarity
Clear definition of services, topics and entities.

## 4 Trust Signals
Legal pages, transparency, authorship and credibility indicators.

## 5 Strategic Communication
Consistency of messaging across the website and external profiles.

## 6 Context and Clarity
How clearly the website explains what the company does.

## 7 Agent Readiness and Governance
How clearly automated systems can interpret available actions, constraints and approval steps, and whether organisation-controlled generative interfaces can communicate within defined, testable and auditable boundaries. Real-world actions remain subject to security controls and explicit human approval.

This dimension includes **AI Output & Liability Readiness** for customer-facing chatbots, voice assistants and agents. Applicable assessments review approved sources of truth, high-risk claims, grounding, uncertainty behaviour, output guardrails, regression testing, traceability, incident response and human escalation. The framework distinguishes independent statements by third-party AI products from outputs of systems deployed, configured or presented by the organisation.

It also includes **Agent Communication Readiness** as a mandatory full-analysis module. This assesses whether an external AI agent, when it has an authorised communication tool, can identify a legitimate telephone, email, contact-form or booking/request channel, formulate the required inquiry and reach a clear human handover or verified service confirmation. Public contact data does not itself prove that a third-party agent can call or send email, and it does not grant permission for external communication.

Every full analysis must generate a client-specific `/.well-known/agent-contact-readiness.json` draft. Contact details, permissions, response times and capabilities must be verified from authoritative evidence or remain explicitly unverified. Real phone, email, message, booking or form tests require explicit customer authorisation.

The core maturity path is: **found → understood → correctly answered → contactable with clear boundaries → safely acted**.

Full methodology and reporting rules: `ai-output-liability-readiness.md` and `agent-communication-readiness.md`.

## 8 Source Concentration & AI Visibility Resilience
How strongly observed AI visibility depends on individual source families or individual AI/search systems. Full analyses should distinguish first-party resilience from third-party dependence and flag concentration risk where one source ecosystem or one AI system dominates the result.

The assessment uses observable citations, source-bearing answers and controlled cross-system tests. It does not infer hidden ranking factors, training data or proprietary model internals.

Full methodology and reporting rules: `source-concentration-risk.md`.

## 9 Physical AI Readiness & Visual Governance

How clearly a physical venue can be identified and how its rules for photography, video, audio, livestreaming, visual AI analysis and biometric identification are communicated to people and compatible AI clients. Every analysis and generated file is additionally governed by the mandatory Privacy-by-Design Standard.

This experimental dimension assesses canonical venue identity, visible human notices, an HTTPS policy, Entry and Exit QR markers, bounded validity, manual override and evidence of client support. It does not claim that a QR code can universally disable third-party cameras, microphones or AI glasses.

Every full analysis must pass through an applicability gate. A relevant venue operated or controlled by the organisation activates the detailed review. If the analysed offer has no such venue, it is recorded as **not applicable**, and this dimension is excluded from the overall score. An unknown status remains open for human review and must not be scored.

Full specification and reporting rules: `physical-ai-governance.md`, `full-analysis-physical-ai-governance.md` and `privacy-by-design-standard.md`.

---

# Optional Data Layer: Natural Query & AI Intent

Future full analyses may activate an optional Natural Query & AI Intent Layer. This layer connects real first-party Google Search Console demand with semantic website analysis and separate AI-answer testing.

It is not an AI-prompt detector. Search Console data must never be used to claim that a query came from ChatGPT, Gemini, AI Overviews or another AI product.

Every analysis records one of three data states:

- **GSC LIVE DATA** – authorised Search Console access is available.
- **GSC EXPORT DATA** – the customer or its agency supplies CSV/XLSX data; this is the preferred low-friction mode where direct access is unnecessary.
- **PUBLIC INTENT MODEL** – no first-party GSC data is available; likely natural-language intents are modeled from public signals and must be labelled as modeled rather than observed demand.

When GSC data is available, the analysis can classify natural-language query clusters, map them to JTBD and decision intent, measure Answer Coverage and Semantic Alignment, assign a Prompt Opportunity Score, and convert priority clusters into answer blocks, FAQ improvements, service-page clarifications and controlled AI test prompts.

The analysis should also record whether the customer itself has appropriate access to Search Console, GA4, Google Business Profile, Bing Webmaster Tools and Tag Manager where relevant. Agency management is compatible with the framework, but business-critical properties should ideally remain accessible to the customer as owner/admin or equivalent.

Full methodology and reporting rules: `natural-query-ai-intent-layer.md`.

---

# AI Visibility Radar

The framework visualizes core dimensions using an AI Visibility Radar.

The radar helps companies prioritise observable structural weaknesses. A higher assessment score does not promise that an AI product will mention or recommend a company.

Source Concentration & AI Visibility Resilience should normally be reported separately as a concentration-risk view because it is based on cross-system output observations rather than only on website structure.

---

# Use Cases

The TH Analytica Framework can be used for:

• AI Readiness analysis of websites  
• evaluation of AI visibility  
• evaluation of source concentration and cross-system visibility risk  
• improving structured information for AI systems
• assessing controlled AI outputs, claim guardrails and human escalation for organisation-operated conversational systems
• assessing Agent Communication Readiness across telephone, email, forms and booking/request paths with explicit authorisation boundaries
• optional analysis of natural-language search demand when first-party GSC data is available
• physical-place identity and visual governance for venues where the module is applicable

---

# Crawling, training and retrieval

- **Crawling** is the automated fetching of public pages.
- **Indexing or corpus presence** records content in a search index or dataset.
- **Model training** adjusts model parameters using selected data and cannot be inferred from crawler access or a public corpus record.
- **Retrieval** selects sources at query time; a source may be retrieved without having been used for model training.
- **Generation** produces an answer and may still omit a technically accessible source.

Files such as `robots.txt`, `ai.txt` and `llms.txt` can communicate preferences and context, but support differs by provider. They do not override law, contracts or provider-specific controls.

Crawler identities should be evaluated by function. Training crawlers, search/retrieval crawlers and user-triggered fetchers must not automatically be treated as equivalent.
---

# Evidence-First Content and Citation Readiness

Every indexable knowledge, service and case-study page should resolve one primary user question or decision, provide a direct answer first, define important entities and support material claims with a primary source, reproducible first-party measurement or explicit evidence label.

The module rejects rigid word-count formulas, invented ranking factors and causal claims based only on sequence. It keeps search performance, observed AI output, business actions and governance or agent-readiness signals separate.

Editorial pages should expose author and dates. Structured data and machine-readable representations must match visible content. Files such as llms.txt or ai.txt may provide context where supported but are not universal standards or proof of retrieval.

Full controls, page template and audit checklist: evidence-first-content-standard.md.
