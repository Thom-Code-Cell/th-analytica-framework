# Agent Readiness Signal Maturity

Status: **Mandatory classification layer within Framework Dimension 7 when agent-discovery, agent-interface or agent-protocol signals are assessed**  
Effective: 2026-09-30

## Purpose

This module prevents technically interesting signals from being mistaken for proven AI visibility or recommendation factors.

Agent-facing mechanisms can differ materially in standards maturity, ecosystem adoption, local implementation quality and observed downstream effect. The TH Analytica Framework therefore reports these dimensions separately.

The module applies when a Full Analysis evaluates agent discovery, agent cards, MCP or comparable interfaces, HTTP Link relations, DNS-based agent discovery, machine-readable agent metadata or similar agentic-web mechanisms.

For an ordinary website that exposes no agent, MCP server or comparable machine-action interface, experimental agent-discovery mechanisms are normally **not applicable** rather than missing.

## Core rule

A signal can be technically valid without being widely adopted.  
A mechanism can be widely adopted without being an open standard.  
A mechanism can be implemented correctly without improving AI recommendations.  
A recommendation can change without the tested technical mechanism being the cause.

These evidence layers must not be collapsed into one score.

## 1. Specification / ecosystem status

Every assessed mechanism receives one of the following labels:

- **STANDARD** — based on a published, stable standards-track or equivalent open-web specification relevant to the tested mechanism.
- **ESTABLISHED_CONVENTION** — a broadly used convention or vocabulary with meaningful ecosystem support, but not necessarily an IETF/W3C standards-track protocol.
- **EMERGING** — an active ecosystem specification or protocol with real implementations or adoption, but still evolving materially.
- **EXPERIMENTAL_DRAFT** — an Internet-Draft, experimental proposal, early project or comparable work in progress whose syntax, status or interoperability may change.
- **PROVIDER_SPECIFIC** — a mechanism controlled by one provider or platform whose support is not portable by default.
- **UNKNOWN** — status could not be verified from authoritative sources.

The label describes the mechanism, not the quality of the analysed website.

## 2. Implementation evidence

Separately record the implementation state for the analysed organisation:

- **NOT_CHECKED**
- **NOT_APPLICABLE**
- **ABSENT**
- **CLAIMED**
- **OBSERVED**
- **VALIDATED**

**OBSERVED** means the mechanism is publicly present.  
**VALIDATED** means the implementation was technically checked against the relevant syntax, endpoint, DNS record, header or protocol requirement within the authorised scope.

Presence alone must not be scored as success if the organisation has no business use case for the mechanism.

## 3. Outcome evidence

Separately record whether any downstream effect has been measured:

- **NOT_MEASURED**
- **OBSERVED_OUTPUT** — an external AI or agent system visibly used, cited, discovered or surfaced the mechanism or related organisation.
- **BASELINE_RETESTED** — a documented baseline → intervention → re-test exists.
- **ATTRIBUTION_UNRESOLVED** — an output change was observed, but causal attribution to the mechanism is not established.

No technical discovery mechanism may be described as an AI ranking factor, recommendation factor or traffic driver without evidence appropriate to that claim.

For recommendation-focused work, use `recommendation-effectiveness-robustness.md`.

## 4. Mandatory reporting table

Where this module applies, the Full Analysis must report at least:

| Field | Required content |
|---|---|
| Mechanism | Name of the signal, protocol or discovery method |
| Purpose | What it is intended to enable |
| Specification / ecosystem status | One of the defined maturity labels |
| Authoritative reference | Current specification, standards or project source |
| Applicability | Why it is relevant or not relevant to this organisation |
| Implementation evidence | NOT_CHECKED / NOT_APPLICABLE / ABSENT / CLAIMED / OBSERVED / VALIDATED |
| Security / governance notes | Authentication, integrity, permission or exposure concerns where relevant |
| Outcome evidence | NOT_MEASURED / OBSERVED_OUTPUT / BASELINE_RETESTED / ATTRIBUTION_UNRESOLVED |
| Scoring treatment | scored, diagnostic-only or not applicable |
| Review date | Date on which status was verified |

A status that can change over time must be re-checked when a new Full Analysis is produced.

## 5. DNS-AID treatment

**DNS for AI Discovery (DNS-AID)** is an experimental agent-discovery mechanism that uses DNS to publish information enabling other agents to discover an organisation's agents or agent capabilities.

As of 2026-09-30, the IETF Datatracker lists `draft-mozleywilliams-dnsop-dnsaid-02` as an **active individual Internet-Draft**. The Datatracker explicitly states that the draft is not endorsed by the IETF and has no formal standing in the IETF standards process. The draft is work in progress and expires on 2026-11-28 unless updated, replaced or otherwise progressed.

The Linux Foundation announced the DNS-AID project on 2026-05-27 as an open source effort for decentralised AI-agent and MCP-server discovery using existing DNS infrastructure.

TH Analytica therefore classifies DNS-AID as:

- Specification / ecosystem status: **EXPERIMENTAL_DRAFT**
- Full-analysis treatment: **diagnostic-only**
- Presence-based score bonus: **none**
- Applicability: organisations that expose or intend to expose externally discoverable agents, MCP servers or comparable agent services
- Outcome claim: **none unless separately measured**

A Full Analysis may inspect relevant DNS-AID records and related security controls when the applicability gate is met. It must not penalise an ordinary website for not publishing DNS-AID records.

Authoritative references:

- IETF Datatracker: https://datatracker.ietf.org/doc/draft-mozleywilliams-dnsop-dnsaid/
- Linux Foundation DNS-AID announcement: https://www.linuxfoundation.org/press/linux-foundation-announces-dns-aid-project-to-advance-decentralized-ai-agent-discovery

## 6. RFC 8288 / HTTP Link treatment

RFC 8288 defines Web Linking and the HTTP `Link` header as an Internet Standards Track mechanism.

TH Analytica therefore treats RFC 8288 itself as **STANDARD** for web linking. However, using a `Link` header to advertise an agent-specific resource does not prove that external AI systems recognise that relation, consume the linked resource or improve recommendations.

For agent-readiness reporting:

- the underlying Web Linking mechanism may be **STANDARD**;
- the specific agent-facing relation or usage pattern must be classified separately;
- implementation can be **OBSERVED** or **VALIDATED**;
- downstream AI/agent consumption remains **NOT_MEASURED** unless directly tested.

Reference: https://www.rfc-editor.org/rfc/rfc8288.html

## 7. MCP, agent cards and other emerging mechanisms

MCP servers, agent cards, agent-to-agent metadata and other agentic-web mechanisms must be labelled according to their **current** authoritative status at the time of analysis.

Do not permanently hard-code an emerging technology as established or experimental. Re-check the current specification source, version, governance model and relevant implementation evidence.

Where several mechanisms overlap, report them separately rather than treating one as a universal replacement for another.

## 8. Agentic Resource Discovery (ARD)

As of 2026-09-30, the authoritative ARD specification is **v0.91**, dated 2026-08-26, with status **Proposal**. TH Analytica classifies ARD as **EMERGING**.

ARD is applicable where an organisation publishes or intends to publish externally discoverable agentic resources. The canonical publisher location is `/.well-known/ard.json`. `rel="ard"` and an `Agentmap:` directive are additional discovery mechanisms. The predecessor `/.well-known/ai-catalog.json` is optional compatibility only.

For implementation evidence, check the manifest structure, domain-anchored `urn:air:` identifiers, resource media type, exactly one of `url` or `data`, representative queries and the reachability of referenced artifacts.

ARD presence does not prove registry ingestion, model consumption, recommendation impact or business outcome.

Reference: https://github.com/ards-project/ard-spec/blob/main/spec/ard.md

## 9. Universal Commerce Protocol (UCP)

As of 2026-09-30, UCP is an actively implemented but evolving open commerce protocol. TH Analytica classifies it as **EMERGING** and applicability-gated.

A supporting business publishes its profile at `/.well-known/ucp`. Positive implementation evidence requires a conformant profile plus the services, transports, capabilities, payment handlers and endpoints that the profile declares. A static placeholder or a JSON statement that UCP is supported is not implementation evidence.

UCP is normally applicable only where a real transaction flow exists, such as lodging booking, retail checkout/order management or food ordering. Missing UCP is not a readiness defect for a non-transactional organisation.

Google documents UCP use across shopping, lodging and food, including lodging booking flows in AI Mode with real-time pricing and availability. Ecosystem use does not remove the requirement to verify the individual business implementation.

References:

- https://ucp.dev/specification/overview/
- https://developers.google.com/universal-commerce-protocol
- https://developers.google.com/hotels/ucp/faq

## 10. Scoring rules

1. Experimental or emerging signals do not earn points merely for existing.
2. Missing experimental signals do not reduce the score unless a documented client use case makes the mechanism necessary and the scoring model explicitly defines that requirement.
3. A stable standard does not earn an AI-visibility bonus merely because it is standards-based.
4. Correct implementation may improve structural Agent Readiness only where it supports a real intended action or discovery path.
5. Recommendation Effectiveness, AI Visibility, business action and attributable business outcome remain separate evidence layers.
6. Unknown or unverified support must remain unknown; it must not be silently converted to absent or failed.

## 11. Recommended Full Analysis output

When applicable, include a subsection titled **Agentic-Web Signal Maturity** with:

1. the mandatory reporting table;
2. a short explanation of the organisation's relevant agent/discovery use case;
3. diagnostic findings and remediation priorities;
4. explicit separation between technical readiness and measured downstream effect;
5. dated references for any emerging or experimental mechanism.

The objective is not to maximise the number of fashionable machine-readable files or protocols. The objective is to make technically justified, interoperable and evidence-backed choices for the organisation's actual agent use cases.
