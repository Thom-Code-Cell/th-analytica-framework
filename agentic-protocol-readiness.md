# Agentic Protocol Readiness — ARD, Interface and UCP

Status: **Mandatory applicability module within Framework Dimension 7 when agent discovery, agent interfaces, booking, ordering, checkout or other machine-action flows are in scope**  
Effective: 2026-09-30

## Purpose

Agent Readiness must not collapse discovery, invocation and transaction execution into one signal.

TH Analytica therefore separates:

1. **Discovery Readiness** — can an agent discover an authoritative resource?
2. **Interface Readiness** — is there a real interface it can use?
3. **Transaction Readiness** — can a booking, order or checkout be executed through a supported transactional protocol?
4. **Governance Readiness** — are identity, permissions, confirmation, financial limits, privacy and human handover defined?

A discovery file is not proof of a callable interface. A declared interface is not proof of a successful transaction.

## ARD — Agentic Resource Discovery

As of 2026-09-30, Agentic Resource Discovery (ARD) v0.91 is an **EMERGING** proposal dated 2026-08-26.

Canonical publisher checks:

- `/.well-known/ard.json` exists when the organisation intentionally publishes agentic resources;
- the document contains an `entries` array;
- each ARD entry has a domain-anchored `urn:air:` identifier;
- each entry contains `displayName`, a valid media `type`, and exactly one of `url` or `data`;
- `representativeQueries` should normally contain 2–5 realistic queries;
- `capabilities` may be used as compact structured discovery tokens;
- `rel="ard"` and `Agentmap:` may advertise the canonical source;
- the predecessor path `/.well-known/ai-catalog.json` is optional compatibility only.

ARD is scored only where discoverable agent resources are an actual client use case. Its presence does not prove that ChatGPT, Gemini, another model or a registry consumed the resource, nor that it improved AI visibility or recommendation probability.

Authoritative reference: https://github.com/ards-project/ard-spec/blob/main/spec/ard.md

## Interface / Invocation Readiness

Where OpenAPI, MCP, A2A, WebMCP or another interface is declared, TH Analytica checks separately:

- endpoint reachability;
- protocol or schema validity;
- declared operations and actual implemented operations;
- authentication and authorisation boundaries;
- write versus read-only capability;
- human approval before consequential actions;
- error and handover behaviour.

A static manifest receives **DISCOVERED** or **DECLARED** evidence only. It does not receive **IMPLEMENTED** or **VERIFIED** status without technical evidence.

## UCP — Universal Commerce Protocol

As of 2026-09-30, UCP is treated as an **EMERGING transactional protocol** with active ecosystem implementation. A business that supports UCP publishes its current business profile at `/.well-known/ucp`.

UCP applicability is normally considered for organisations with real transactional flows, including:

- lodging availability and booking;
- retail cart, checkout and order management;
- food ordering and fulfilment;
- other supported commerce or reservation workflows.

When UCP is applicable, verify:

- a conformant `/.well-known/ucp` business profile;
- the declared UCP protocol version;
- real services and transports;
- declared capabilities and schemas;
- payment handlers where required;
- reachable endpoints;
- booking/order/checkout state handling;
- cancellation, modification or refund rules where relevant;
- authentication, identity and user-confirmation boundaries;
- Merchant-of-Record and data-controller responsibilities where relevant to the implementation.

A static JSON file that merely says "UCP supported" or "not supported" is not positive UCP implementation evidence.

Authoritative references:

- https://ucp.dev/specification/overview/
- https://developers.google.com/universal-commerce-protocol
- https://developers.google.com/hotels/ucp/faq

## Applicability and scoring

UCP absence is **NOT_APPLICABLE**, not a failure, when the organisation has no relevant transactional use case.

ARD absence is **NOT_APPLICABLE**, not a failure, when the organisation does not publish or intend to publish externally discoverable agentic resources.

When applicable, evidence states follow the Framework's Agent Readiness Signal Maturity model:

- **NOT_MEASURED**
- **DISCOVERED**
- **DECLARED**
- **IMPLEMENTED**
- **VALIDATED**
- **OBSERVED_DOWNSTREAM** where an independently observed downstream effect exists

Do not award AI Visibility, recommendation or revenue points merely because ARD, UCP, MCP, A2A or another protocol is present.

## Hotel and tourism analysis

For lodging and tourism, the Full Analysis should additionally separate:

- machine-readable property and offer identity;
- real-time availability and pricing evidence;
- booking flow and booking-state handling;
- guest data and payment boundaries;
- cancellation/change logic;
- human handover;
- UCP or another actually implemented booking interface;
- observed booking or recommendation outcomes.

This creates the evidence chain:

**AI Visibility → Recommendation Effectiveness → Agent Discovery → Interface Readiness → Transaction Readiness → Governance → Observed Outcome**
