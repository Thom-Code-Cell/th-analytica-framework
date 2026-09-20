# Agent Portability

Status: **Mandatory module within Framework Dimension 7: Agent Readiness and Governance**  
Effective: 2026-09-20

## Purpose

Agent Portability assesses whether an organisation can move agent knowledge, rules, workflows and integrations between compatible AI systems without having to rebuild the entire operating model around one model provider.

Portability is distinct from Agent Readiness and Agent Governance:

- **Agent Readiness** asks whether an agent can understand a possible action and its prerequisites.
- **Agent Governance** asks what an agent is allowed to do, under which identity, permission, approval and audit rules.
- **Agent Portability** asks whether the knowledge, controls and capabilities can be reused, exported or reconnected across different compatible agent runtimes and providers.

A portable architecture reduces avoidable provider lock-in. It does not imply that every agent platform supports the same tools, formats or behaviours.

## Core principle

Business knowledge, policy and workflow logic should live in authoritative, versioned sources that are separable from a single model or chat product.

The preferred maturity path is:

**provider-bound configuration → exportable instructions → reusable skills/workflows → documented interfaces → model-neutral governance → tested multi-runtime portability**

## Mandatory full-analysis checks

Every full analysis reviews, where applicable:

1. **Canonical source of truth**
   - Are business facts, policies and workflow rules stored outside a single model conversation or vendor-specific prompt store?
   - Can they be retrieved or exported in documented formats?

2. **Instruction portability**
   - Are reusable instructions, playbooks or skills versioned and separated from model-specific tuning?
   - Where supported, are skill/package formats documented rather than embedded only in one vendor UI?

3. **Interface portability**
   - Are actions exposed through documented APIs, MCP servers, webhooks or other explicit interfaces where appropriate?
   - Can an equivalent authorised client reconnect without reverse-engineering a proprietary workflow?

4. **Governance portability**
   - Are permissions, approval thresholds, prohibited actions, data-access rules and human handover policies represented outside a single provider?
   - Can the same governance intent be applied to another compatible runtime?

5. **Data and memory portability**
   - Can relevant organisation-controlled data, logs, configuration and approved memory be exported, migrated or reconstructed?
   - Sensitive or personal data must remain subject to privacy, security and retention requirements.

6. **Identity and credential separation**
   - Are credentials, service accounts and agent identities managed independently from the model provider where technically possible?
   - A model change must not silently inherit permissions that were never approved for the new runtime.

7. **Fallback and continuity**
   - Is there a documented fallback if one model, tool or provider becomes unavailable?
   - Can critical processes continue manually or through another compatible system?

8. **Cross-runtime verification**
   - Where authorised and feasible, can the same defined task be executed or interpreted in at least two compatible runtimes without material rule drift?
   - Differences in tool semantics, output format and provider policy must be recorded rather than hidden.

## Evidence levels

Portability findings must be labelled with evidence:

- **Verified** – supported by repository, configuration, export, API documentation or authorised runtime test.
- **Documented** – stated in authoritative internal or public documentation but not technically tested.
- **Inferred** – plausible from architecture but not directly verified.
- **Unverified** – insufficient evidence.

Marketing claims such as “vendor-neutral”, “open” or “portable” are not accepted as technical proof.

## Full-analysis result

Every full analysis must include:

- portability status and evidence level,
- identified provider-bound components,
- model-neutral components,
- reusable skills/workflows,
- interface dependencies,
- governance and credential dependencies,
- migration/fallback risks,
- recommended remediation steps.

Every full analysis must also generate a client-specific `/.well-known/agent-portability.json` draft. This is a TH Analytica interoperability artefact, not a universal standard and not evidence that third-party systems will consume it.

## Recommended machine-readable fields

A client-specific portability draft may include:

- `version`
- `organisation`
- `canonicalSourceOfTruth`
- `portableInstructions`
- `skillPackages`
- `interfaces`
- `mcpServers`
- `providerSpecificDependencies`
- `governanceSources`
- `credentialBoundaries`
- `dataExportPaths`
- `fallbackPaths`
- `testedRuntimes`
- `evidenceLevel`
- `lastVerified`

## Boundaries

Agent Portability does not mean identical behaviour across providers. Different models and runtimes may interpret instructions differently, support different tool protocols, impose different policies or expose different memory and identity systems.

The framework therefore assesses **transferability of architecture and controls**, not guaranteed behavioural equivalence.

Portability must never weaken security, privacy, human approval or legal obligations merely to make migration easier.
