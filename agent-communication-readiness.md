# Agent Communication Readiness

Status: **Mandatory module within Framework Dimension 7: Agent Readiness and Governance**  
Effective: 2026-09-20  
Voice / Call Agent Readiness extension: 2026-10-02

## Purpose

Agent Communication Readiness assesses whether an external AI agent, when equipped with an authorised communication tool, can identify a legitimate contact channel, formulate the required request, reach the organisation and hand the interaction to a responsible human or verified service endpoint.

The module evaluates the organisation's public communication readiness. It does **not** assume that an external AI product has telephone, email or messaging capability, and it does not grant such a product permission to contact the organisation.

## Core diagnostic question

**Can an external AI agent contact this organisation through a published channel and pursue the user's goal up to a clear, authorised human handover or verified service confirmation?**

## Mandatory checks

Every applicable assessment reviews:

1. canonical telephone, email, contact-form and booking/request channels;
2. consistency of those channels across the official website and trusted public profiles;
3. technical reachability of the published contact path;
4. the information an inquiry must contain, such as date, party size, object, service, location or callback details;
5. published opening hours, service windows or response expectations where relevant;
6. human handover, confirmation and escalation boundaries;
7. privacy, data-minimisation and transparency requirements for agent-mediated communication;
8. the difference between a public contact path and an external agent's actual communication capability or permission.

## Voice / Call Agent Readiness

Voice / Call Agent Readiness is a mandatory submodule when telephone or voice contact is material to the customer journey. It evaluates whether a voice-capable AI agent, acting with user authorisation, can reach the organisation, obtain the information needed for the user's goal and stop at the correct confirmation or human-handover boundary.

The diagnostic question is:

**Can an authorised voice agent complete the information-gathering or request-preparation part of a call reliably without creating an unverified commitment?**

The assessment records, where applicable:

1. whether the canonical telephone number is current and consistent across authoritative sources;
2. whether published service or opening hours are usable for call timing;
3. whether IVR or menu navigation can be understood without relying on undocumented visual context;
4. whether staff can recognise and appropriately handle an AI-agent disclosure;
5. whether prices, availability, requirements and policy answers match authoritative digital sources;
6. whether a reservation, appointment, order or other request requires explicit confirmation before becoming binding;
7. whether cancellation, modification, waiting-list, callback and escalation paths are clear;
8. which personal data the agent would need to disclose and whether that data is necessary for the task;
9. whether recording, transcription or automated-agent disclosures create additional transparency or compliance requirements;
10. whether the agent can transfer or hand the interaction back to the user or a responsible human when uncertainty or a consequential decision appears.

A successful informational call is not evidence that autonomous booking, payment or another consequential transaction is safe or authorised.

Current third-party implementations may be used as dated evidence that voice-agent calling exists in practice, but vendor availability, device requirements and regional restrictions are **not** scoring criteria. The TH Analytica score remains based on the analysed organisation's observable readiness and authorised test evidence.

## Evidence states

- **Documented**: a contact channel is published by an authoritative source.
- **Reachable**: the technical endpoint or channel is observable as available without performing an unauthorised interaction.
- **Authorised test verified**: a real phone, email or other contact test has been performed with explicit authorisation and the outcome is recorded.
- **Human handover verified**: the organisation's confirmation or escalation point is documented and, where authorised, tested.
- **Voice path documented**: the telephone journey, IVR/menu structure, required information and confirmation boundary are documented from authoritative evidence.
- **Authorised voice test verified**: an AI-mediated or controlled voice test has been explicitly authorised, performed and recorded with its date, tool/provider, task and outcome.

A published phone number or email address alone is not proof that an AI agent can call or send mail. Likewise, successful delivery does not authorise booking, payment, professional advice or another consequential action.

## Full-analysis requirement

Every TH Analytica full analysis must include an Agent Communication Readiness assessment inside the Agent Readiness and Governance dimension.

The analysis must also generate a client-specific draft named:

`/.well-known/agent-contact-readiness.json`

The draft must never invent a phone number, email address, endpoint, opening hour, response time, permission or agent capability. Unknown fields remain unverified until confirmed from authoritative evidence.

For each client, the generated artefact should document:

- verified or still-unverified communication channels;
- the intended use of each channel;
- required inquiry data;
- human handover and confirmation points;
- actions that remain prohibited or require explicit human approval;
- whether a live communication test was authorised and performed;
- for material telephone journeys, the Voice / Call Agent Readiness result, including IVR/menu handling, disclosure, information consistency, confirmation boundaries and human handover.

## Live communication tests

A real telephone call, email, message, booking request or form submission is an external action. It may only be performed when the customer has explicitly authorised that test and the executing agent or tool has the required capability and access.

The default full-analysis mode is therefore **analyse and prepare, not contact**.

## Governance boundaries

Agent Communication Readiness follows these principles:

- website readiness does not grant outbound communication capability;
- tool capability does not equal permission;
- user authorisation does not remove the organisation's confirmation requirements;
- payments, logins, binding bookings, professional commitments and other consequential actions require separately verified controls;
- privacy and sector-specific requirements remain applicable;
- the organisation remains the source of truth for availability, price, scope and final confirmation.

## Recommended machine-readable fields

A client-specific `agent-contact-readiness.json` may include:

- `entity`
- `canonicalWebsite`
- `status`
- `diagnosticQuestion`
- `contactChannels`
- `inquiryData`
- `handover`
- `governance`
- `sources`
- `lastUpdated`

The file is a TH Analytica interoperability and governance artefact. It is not a universal web standard and does not guarantee support by third-party AI systems.
