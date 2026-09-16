# AI Output & Liability Readiness

## Purpose

This module assesses whether an organisation-controlled conversational AI system can provide customer-facing information within defined, testable and auditable boundaries.

It applies to chatbots, voice assistants, AI agents and other generative interfaces that an organisation deploys, configures or presents as part of its own digital service. It does not assess unrelated statements made independently by third-party AI products.

The module is part of **Framework Dimension 7: Agent Readiness and Governance**. It distinguishes the ability to perform an action from the ability to communicate reliably before, during and after that action.

## Core principle

An agent-ready organisation should be able to demonstrate:

> found → understood → correctly answered → safely acted

Visibility, retrieval and tool access alone are insufficient where generated statements can affect purchasing decisions, professional qualifications, prices, availability, guarantees, medical information, contractual terms or other consequential matters.

## Applicability gate

Record one of three states:

- **Applicable**: the organisation operates, configures or presents a generative system that communicates with customers, prospects, employees or other external parties.
- **Not applicable**: no organisation-controlled generative interface is in use or planned within the assessed scope.
- **Unknown**: operation, ownership or configuration cannot be verified and requires human clarification.

Only applicable deployments receive a detailed score. Unknown must not be treated as compliant.

## Assessment controls

### 1. Ownership and responsibility

- The operator, technical provider and accountable business owner are identified.
- The system is clearly disclosed as an automated interface where appropriate.
- Responsibility is not shifted to the model merely because outputs are probabilistic.

### 2. Approved source of truth

- Approved sources are documented and versioned.
- Retrieval is restricted to relevant, current and authorised information.
- Visible website content, structured data, product data and chatbot knowledge do not materially contradict one another.
- Updates to prices, services, personnel, qualifications, availability and terms propagate through a defined process.

### 3. High-risk claim register

The organisation identifies claims that require stricter controls, including where relevant:

- professional titles, licences and qualifications
- health, medical, legal or financial statements
- prices, discounts, availability and delivery promises
- guarantees, certifications and performance claims
- contractual terms, cancellation rules and eligibility
- safety instructions and access permissions

Each claim class has an approved response rule, evidence source, owner and review interval.

### 4. Grounding and uncertainty behaviour

- Material claims are grounded in approved evidence.
- The system does not invent missing facts or silently convert uncertainty into certainty.
- Defined fallback responses are used when evidence is missing, conflicting, stale or outside scope.
- High-impact questions can be escalated to a qualified person before a commitment is made.

### 5. Output guardrails

- Prompt instructions and policy rules define prohibited or restricted statements.
- Deterministic validation or post-generation checks are used for critical claim classes where feasible.
- Tool results and backend data are validated before being communicated.
- Guardrails cover multilingual and adversarial formulations, not only the expected happy path.

### 6. Pre-release and regression testing

Testing includes:

- representative customer questions
- ambiguous, leading and adversarial prompts
- requests involving protected titles or qualifications
- outdated or conflicting source data
- unavailable products, services or appointment slots
- language variants and spelling variations
- attempts to override system rules
- repeated tests after model, prompt, data or tool changes

Results must separate observed pass/fail evidence from assumptions.

### 7. Logging, traceability and incident response

- The deployed model, prompt/policy version, source version and tool calls can be reconstructed to an appropriate extent.
- Personal and confidential data are minimised and protected.
- Users have a correction or escalation path.
- Materially false outputs trigger containment, correction, root-cause analysis and retesting.
- Retention periods and access rights are defined.

### 8. Human approval and action boundaries

- Consequential actions require proportionate authentication, authorisation and confirmation.
- The interface distinguishes information from a binding offer or completed transaction.
- Human review is mandatory where law, risk or internal policy requires it.
- A safe stop is available if confidence, source quality or authorisation is insufficient.

## Evidence requirements

Acceptable evidence can include:

- system and data-flow documentation
- approved knowledge-source inventory
- claim register and response rules
- prompt and guardrail versions
- red-team and regression-test records
- sample transcripts with personal data removed
- monitoring, escalation and incident procedures
- named owners and review dates

A vendor statement or a single successful demonstration is not sufficient evidence of readiness.

## Reporting

Full analyses report:

1. applicability state
2. observed deployment scope
3. critical claim classes
4. evidence reviewed
5. control gaps and severity
6. tested prompts and observed results
7. priority remediation actions
8. residual risk and human-review requirements

Suggested subscore areas:

- Source-of-Truth Control
- Claim & Policy Guardrails
- Grounding & Uncertainty
- Testing & Monitoring
- Traceability & Incident Response
- Human Oversight & Action Safety

The module is a technical and governance assessment, not legal advice. Legal conclusions must be reviewed by qualified counsel in the relevant jurisdiction.

## Legal signal: OLG Hamm, 12 May 2026

A 2026 decision of the Higher Regional Court of Hamm concerning a company-operated website chatbot is recorded as a governance signal: customer-facing statements generated through an organisation-controlled chatbot may be attributable to the organisation as its own commercial communication. The case concerned incorrect statements about medical specialist qualifications.

The decision should not be presented as a universal rule for every third-party AI statement or every jurisdiction. At the time of inclusion, further appeal was permitted. Analyses must state the jurisdiction, procedural status and assessment date, and must avoid presenting this module as legal advice.

## Review cadence

Review at launch and after any material change to:

- model or provider
- system prompt or policy
- retrieval source or knowledge base
- product, price, personnel or qualification data
- connected tools and action permissions
- applicable law or material case law
