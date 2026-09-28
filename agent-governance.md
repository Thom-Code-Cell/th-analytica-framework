# Agent Governance

Status: **Mandatory module within Framework Dimension 7: Agent Readiness and Governance**  
Effective: 2026-09-20

## Purpose

Agent Governance assesses whether an organisation defines and can evidence the rules that constrain AI-agent behaviour before, during and after an action.

Agent Readiness asks whether an agent can understand a possible action and its prerequisites. Agent Governance asks **what the agent is allowed to do, under which conditions, with which limits, and how the decision and execution can be audited**.

Capability is therefore not treated as permission. A documented action, API, tool, contact path or machine-readable skill does not by itself authorise execution.

## Core diagnostic question

**What may an AI agent do for this organisation, under which identity, permission and approval rules, and how can those rules and actions be verified or revoked?**

## Mandatory checks

Every full analysis reviews, where applicable:

1. agent identity and the trust boundary for authenticated versus unauthenticated actors;
2. roles, permissions and least-privilege access;
3. explicitly allowed, conditionally allowed and prohibited actions;
4. human-approval thresholds for consequential actions;
5. financial, transactional and commitment limits;
6. access to personal, confidential or otherwise sensitive data and the applicable data-minimisation rules;
7. runtime constraints such as scope, rate limits, retries, timeouts and session expiry;
8. audit logging and traceability for requests, approvals, actions and outcomes;
9. permission expiry, revocation and emergency-stop or kill-switch procedures;
10. incident handling, escalation and human handover.

## Evidence states

- **Documented**: a rule or control is stated by an authoritative source.
- **Implemented**: a technical or organisational control is observable in the assessed environment.
- **Tested**: the control has been exercised in an authorised test and the result is recorded.
- **Human-reviewed**: a responsible person has verified the rule, boundary or exception.

Documentation alone must never be reported as proof that a control is technically enforced.

## Full-analysis requirement

Every TH Analytica full analysis must report **Agent Readiness** and **Agent Governance** as distinct results inside Framework Dimension 7.

The Agent Governance result must cover at least:

- identity and role boundaries;
- permission scope;
- allowed and prohibited actions;
- approval thresholds;
- financial and data-access limits where relevant;
- logging and traceability;
- revocation, expiry and emergency stop;
- incident escalation and human handover.

Every full analysis must also generate or update a client-specific draft:

`/.well-known/ai-governance.json`

The draft is a TH Analytica interoperability and governance artefact. It is not a universal web standard and does not grant capabilities or permissions to third-party agents.

Unknown controls remain explicitly unverified. The analysis must not invent payment limits, access rights, authentication methods, retention periods, approval roles or technical enforcement.

## Default safety boundary

Unless a real implementation has been separately verified and authorised, the framework assumes:

- no autonomous payment;
- no autonomous login or account takeover;
- no autonomous form submission that creates a binding commitment;
- no irreversible data modification or deletion;
- no access to personal or confidential data beyond the verified purpose;
- consequential actions require explicit human approval;
- outbound communication requires both technical capability and explicit authorisation.

These are assessment defaults, not claims about what every external AI product can or cannot technically do.

## Recommended machine-readable fields

A client-specific `ai-governance.json` may include:

- `entity`
- `frameworkModule`
- `status`
- `identity`
- `roles`
- `permissions`
- `allowedActions`
- `conditionalActions`
- `prohibitedActions`
- `approvalThresholds`
- `financialLimits`
- `dataAccess`
- `runtimeConstraints`
- `auditLogging`
- `revocation`
- `emergencyStop`
- `incidentEscalation`
- `sources`
- `lastUpdated`

## Relationship to other modules

- **Agent Readiness**: can an agent understand the action, inputs, outputs and next step?
- **Agent Communication Readiness**: can an authorised agent identify and use a legitimate communication path up to a verified handover?
- **AI Output & Liability Readiness**: can organisation-controlled generative systems communicate within tested output boundaries?
- **Agent Governance**: what may an agent do, and how are permissions, approvals, limits and evidence controlled?
- **Physical AI Governance**: how are comparable governance principles communicated for sensor-based AI systems in physical places?

## User-agent duties: operational review (draft-informed)

The W3C TAG published *Web User Agents* as a **Group Note Draft** on 23 September 2026. It discusses protection, honesty and loyalty. This is work in progress, not a W3C Recommendation, certification or direct implementation mandate: https://www.w3.org/TR/web-user-agents/ . TH Analytica uses the following as its own diagnostic matrix, not as a claim of W3C compliance.

| Duty | Testable question | Evidence / open state |
| --- | --- | --- |
| Protection and data minimisation | Can a read-only page or message trigger side effects, disclose secrets or broaden permissions? Is only necessary data sent? | Reproduce in an isolated test; permissions, egress logs and redaction evidence. Unknown = unverified. |
| Honesty | Are source, action, approval and actual result distinguished from a plausible generated confirmation? | Tool trace, source URL, backend state and user-facing confirmation compared. |
| Loyalty and consent | Does the agent serve the user's stated goal rather than instructions embedded in a page, email, PDF or tool output? | Controlled indirect-injection and refusal/approval tests. |

No website, email, PDF, image OCR or tool response may grant new authority merely by containing instructions. Writing, publication, messaging, payment, deletion and binding transactions require a separately authorised action path and human approval where consequential. A passing document review does not prove runtime enforcement.

## Scope limitation

This module is a technical and operational governance assessment. It is not legal advice, a certification of regulatory compliance, or a guarantee that a third-party AI system will honour a published policy.
