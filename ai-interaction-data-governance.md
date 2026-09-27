# AI Interaction & Data Governance

Status: **Mandatory applicability check for Full Analyses**  
Effective: 2026-09-27

## Purpose

This module assesses organisation-controlled AI interaction surfaces that accept open or semi-open user input, including chatbots, voice assistants, agent interfaces, copilots and other generative forms.

It asks two separate questions:

1. **Is the interaction surface actually needed for the intended user outcome?**
2. **If it is used, are data collection, processing, secondary use, retention, security, transparency and human escalation governed in a proportionate and verifiable way?**

The module complements AI Output & Liability Readiness and Agent Governance. Output governance controls what the system says. Agent Governance controls what it may do. AI Interaction & Data Governance controls what information the interaction collects or derives, why it is processed, where it flows and whether the same business outcome can be achieved with a narrower, lower-risk interaction design.

This is a technical and governance assessment, not legal advice.

## Applicability gate

Record one of three states:

- **Applicable**: the organisation operates, configures or presents an AI-assisted interface that accepts free text, voice, image, file or comparable user input, or plans to deploy one in the assessed scope.
- **Not applicable**: no organisation-controlled generative or AI-assisted user-input interface is in use or planned within the assessed scope.
- **Unknown**: ownership, provider, data flow or intended deployment cannot be verified and requires human clarification.

Only applicable deployments receive a detailed control assessment. Unknown must not be treated as compliant.

## Core controls

### 1. Interaction inventory and accountability

Document the interaction surface and business purpose; responsible organisation and accountable owner; technical and model providers; input types, derived data and connected tools; jurisdictions and relevant user groups; and whether children, patients, employees or other vulnerable groups may use the interface.

### 2. Sensitive-input exposure

Assess whether users can submit or reveal sensitive or highly personal information through normal use, including health information, political or religious views, sexual life or orientation, biometric or genetic information, financial details, credentials, confidential business information or information about third parties.

A warning such as “do not enter sensitive data” is not by itself treated as a technical control. The assessment also checks whether the interface design encourages broad or personal disclosure.

### 3. Purpose, legal basis and consent

For each material processing purpose record purpose, data categories, accountable controller, legal basis or open legal-review state, whether explicit consent is required or relied upon, withdrawal and objection paths where applicable, and whether the interface can still provide a useful service if optional processing is declined.

Unknown legal assumptions remain open. The framework does not invent consent or infer a lawful basis from continued use.

### 4. Secondary use, advertising, profiling and model improvement

Review whether user inputs, derived data, conversation history or metadata can be reused for advertising, ad personalisation, profiling, analytics beyond operational necessity, model training or product improvement, cross-service enrichment, or disclosure to additional parties.

Primary service delivery and secondary use are reported separately. Opt-out settings are not treated as equivalent to explicit consent where applicable law requires a stronger basis.

### 5. Data minimisation, memory, retention and deletion

Check the minimum input needed for the task; whether structured fields or bounded actions can replace open free-text collection; conversation memory and persistence; retention and deletion; user-access and correction paths; failed or unauthenticated sessions; and whether data can be processed locally, transiently or de-identified where appropriate.

### 6. Security, access and data flows

Review authentication and authorisation, least-privilege access, transport and storage protection, logs and administrative access, processors and subprocessors, cross-border transfers where relevant, incident handling, and separation between production and testing data.

### 7. Transparency and human control

Users should be able to understand, where applicable, that they are interacting with an automated system, who is responsible, what data is processed and why, whether humans may review conversations, how to reach a person, and how to stop, correct or escalate an interaction.

### 8. Testing and evidence

Where authorised, test representative and adversarial interactions for sensitive-data entry, third-party information, consent and preference handling, memory and deletion, prompt injection against data rules, multilingual variants, failure paths and human escalation.

A vendor statement or privacy-policy paragraph is not proof that runtime controls work.

### 9. Necessity and safer-alternative test

Every applicable Full Analysis must ask whether the intended user outcome actually requires an open generative interface.

Possible lower-risk alternatives include clearer first-party website content, structured FAQs and answer blocks, machine-readable service and entity data, bounded forms, defined Agent Actions, read-only lookup endpoints, authenticated workflows with explicit confirmation, or human handover.

**“No chatbot required” is a valid and sometimes preferable outcome.**

## Evidence states

Use the standard TH Analytica evidence labels: **Implemented, Observed, Attributed, Hypothesis, Not measured** and, where relevant, **Open legal review**.

## Full-analysis output

Applicable analyses report interaction inventory and ownership, an appropriate data-flow map, sensitive-input exposure, primary and secondary processing purposes, consent or legal-basis status, retention/deletion/memory controls, processors/transfers/security, transparency and human handover, runtime evidence where authorised, the necessity assessment, remediation priorities and open legal questions.

## Legal signal: LG Köln, 17 September 2026

The framework records the decision of the Regional Court of Cologne, case **33 O 120/24**, concerning Snapchat “My AI”, as a current governance signal for open generative interfaces. Published case summaries report that the court applied Article 9 GDPR to sensitive information entered through the chatbot and rejected the idea that a general warning against entering sensitive data was sufficient for the challenged processing.

This decision is not treated as a universal rule for every AI interface, jurisdiction or processing purpose. Analyses must identify the applicable jurisdiction and obtain qualified legal review where required.

Case index: https://dejure.org/2026,28756

## Relationship to other modules

- ai-output-liability-readiness.md: what the organisation-controlled AI says.
- agent-governance.md: what an agent is permitted to do.
- agent-communication-readiness.md: how an authorised agent can contact or hand over.
- privacy-by-design-standard.md: mandatory privacy baseline for all analyses and generated artefacts.
- physical-ai-governance.md: perception and action rules in physical places.
