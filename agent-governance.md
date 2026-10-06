# Agent Governance

Status: **Mandatory module within Framework Dimension 7: Agent Readiness, Governance and Portability**

Effective: 2026-09-20

Agentic Control & Containment extension: 2026-10-06

## Purpose

Agent Governance assesses whether an organisation defines and can evidence the rules that constrain AI-agent behaviour before, during and after an action.

Agent Readiness asks whether an agent can understand a possible action and its prerequisites. Agent Governance asks **what the agent is allowed to do, under which conditions, with which limits, and how the decision and execution can be audited**.

Capability is therefore not treated as permission. A documented action, API, tool, contact path or machine-readable skill does not by itself authorise execution.

**Agent Readiness without Agent Governance is incomplete.** Readiness and governance remain distinct results; a high readiness score cannot substitute for evidence that action boundaries work.

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

## Agentic Control & Containment

This is a **mandatory review area within Agent Governance**, not a new framework dimension, score or certification. It operationalises the existing mandatory checks above. The [July 2026 coordination incident](evidence/2026-07-agent-coordination.md) supplies external evidence and explicitly separates reported observations from TH Analytica's interpretation.

Every Full Analysis records applicability per control: `applicable`, `not_applicable` with a reason, or `open`. An organisation with no controlled agent runtime may have public action boundaries to review while runtime tests are not applicable. Lack of access or unknown implementation is `open`, never proof of absence or a reason to mark a control passed. Collective behaviour must consider shared services even when the design calls its agents isolated.

| ID | Required control | Question and minimum evidence | Authorised verification / expected boundary |
| --- | --- | --- | --- |
| ACC-01 | Authority Boundary | Who grants which actor authority over which tools, data and resources? Record owner, role/scope matrix and policy version. | A permitted operation succeeds; an out-of-scope action or peer claim of authority is denied before execution. |
| ACC-02 | Communication Boundary | Which peers, destinations and shared stores may be used? Record approved channels, tenant/run isolation and egress configuration. | Approved communication works; unapproved recipients and cross-run shared-store access are denied and logged. Include indirect channels, caches and package services. |
| ACC-03 | Goal Boundary | What is the authorised objective, allowed delegation, budget and safe exit? Record stop conditions and goal-change approval. | An impossible task stops or escalates; a peer/tool instruction cannot silently expand the objective or turn evaluation success into permission. |
| ACC-04 | Privilege/Credential Escalation | Are credentials scoped, short-lived and isolated from the model where feasible? Record credential broker, role and delegation limits without publishing secrets. | A scoped test identity cannot expand its role, inherit another run's credentials or reuse an expired credential. Use synthetic credentials only. |
| ACC-05 | Collective/Emergent Behaviour | Can shared state or delegation create unauthorised collective work? Record agent topology, lineage, shared resources and aggregate budgets. | A controlled multi-agent scenario cannot pool permissions or bypass aggregate limits; denial propagates to delegated tasks. |
| ACC-06 | Human Approval/Oversight | Who approves consequential actions and receives alerts? Record approver, exact action/resource binding, expiry and escalation owner. | Missing, expired, replayed or mismatched approval blocks action. An agent cannot approve itself or treat another agent's GO as human approval. |
| ACC-07 | Auditability | Can an independent reviewer reconstruct decisions and side effects? Record protected tool/backend logs, run/parent IDs, policy version, approvals, denials, timestamps and retention rules. | Compare claimed action with backend state; log tampering is prevented or detected. Minimise/redact personal data and secrets; private chain-of-thought is not required. |
| ACC-08 | Containment/Revocation | Can the owner stop the whole authorised execution scope? Record isolation, credential/session revocation, child jobs, queues, persistent state and recovery procedure. | Emergency stop and revocation prevent new actions, address in-flight effects and delegated jobs, and require explicit restart approval. Measure stop latency and residual effects. |
| ACC-09 | Technical Policy Enforcement | Where does a policy decision bind execution outside the model's discretion? Record policy decision/enforcement points, version and coverage of tools, network, storage and relevant sensors. | Allowed action succeeds; denial, invalid/stale policy and enforcement-service failure block covered actions. Test alternate paths and ensure acknowledgement follows actual enforcement, not merely policy receipt. |

Tests require an explicitly authorised scope and isolated fixtures. This matrix does not authorise live intrusion, external messaging, credential discovery or production changes.

### Full-analysis record and decision

For **each ACC ID**, record: applicability and reason; responsible owner; system/runtime and version; boundary and policy; evidence source/date; separate `Documented`, `Implemented`, `Tested`, `Human-reviewed` evidence; enforcement point; authorised test scope; expected and observed result; test timestamp and log reference; residual risk; remediation owner and retest date. Missing evidence is `unverified`; unperformed tests are `not_measured`. A failed test remains a failure even if the control is documented.

The report may be delivered with explicit open findings after human review, but **operational readiness for the affected action must not be approved** while a required boundary is unknown, a denial test fails or revocation is unverified. No averaged score can cancel this gate. `not_applicable` needs a reviewed rationale and contributes no positive score. A passing test establishes only the tested environment, version, action and time, not universal security.

Reuse the existing `/.well-known/ai-governance.json` draft rather than publishing another policy file. An optional `agenticControlContainment` assessment section can carry ACC IDs, applicability, evidence states, test result and review status. Defaults are open/unverified/not_measured; never fill them from a website score. Detailed logs, credentials and sensitive topology stay in the protected evidence register; public drafts contain only approved summaries.

### Quick-Check criteria and wording

Within the existing non-weighted governance diagnosis, inspect only supplied or actually retrieved public evidence for: declared authority/action limits, communication/delegation limits, human approval/handover, audit/incident responsibility and revocation/enforcement claims. Cite the observed source and date; distinguish a declaration from evidence of a control.

Do not run actions, credential tests, sandbox escapes or agent-to-agent communication. Internal implementation, collective behaviour, effective containment and technical enforcement remain `not_measured`. Missing public documentation is a documentation gap, not proof of absent internal controls. Do not add a score bonus for a policy file or a score penalty for inaccessible runtime evidence.

Report wording: “Public action and approval boundaries: [source-backed finding or not observed]. Runtime enforcement and containment: not measured. Agent Readiness without Agent Governance is incomplete; operational verification requires the Full Analysis and an authorised test scope.”

## Physical AI connection: PPS / PPS+

The shared design principle is **machine-readable boundaries plus technical enforcement**. [PPS](personal-privacy-signal.md) communicates a local privacy preference; [PPS+](pps/PPS-PLUS.md) describes richer capture, inference, retention/use and action boundaries. A compatible receiver must map supported restrictions to a real enforcement point and report unsupported controls honestly. Receipt of a policy is not proof of enforcement, authority, consent or legal compliance.

This is a conceptual mapping to ACC-01/06/07/08/09, not evidence that PPS prevents agent coordination or all sensor misuse. Preserve existing protocol and safety semantics; a failed or missing signal is not permission to resume capture. The [reference receiver](pps/reference-receiver-android/README.md) limits enforcement to its own supported capture path; it does not establish full PPS+ enforcement of profiling or training. The [recorded BLE experiment](pps/tests/2026-09-30-android-camera-stop.md) concerns named reference builds/devices. No commercial-glasses integration is established by this assessment, and manufacturer contact or feasibility discussion is not integration evidence.

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
