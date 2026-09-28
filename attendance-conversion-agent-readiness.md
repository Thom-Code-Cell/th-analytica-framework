# Attendance Conversion & Event Agent Readiness

Status: **Mandatory applicability module for event-related Full Analyses**  
Effective: 2026-09-28

## Purpose

Attendance Conversion & Event Agent Readiness extends Event Visibility beyond discovery and ticket acquisition. It assesses whether an event operator can reduce avoidable no-shows, release unused capacity and support authorised agent-assisted attendance actions without treating capability as permission.

The module follows the chain:

**Visibility → Recommendation → Conversion → Attendance → Agent Action → Governance**

It does not assume that reminder messages, AI agents or waiting lists will reduce no-shows. Outcomes must be measured against an observed baseline where data is available.

## Applicability gate

Activate this module when the analysed organisation operates or controls an event, ticket, registration, reservation or capacity-management process.

If there is no attendance, registration or capacity workflow, record the module as **not applicable**. Unknown integration capability remains **not measured** until authoritative evidence is available.

## Mandatory checks

Where applicable, a Full Analysis reviews:

1. ticketing or registration system and available API, webhook, export or integration paths;
2. authoritative event, ticket and attendance status sources;
3. reminder capability and permitted communication channels;
4. explicit attendance confirmation flows;
5. cancellation or release flows for unused places;
6. waiting-list or reallocation capability;
7. identity and ticket-holder verification before consequential actions;
8. consent, communication preferences, data minimisation and retention;
9. human-approval boundaries for cancellations, transfers, refunds and other consequential actions;
10. audit logging for reminders, confirmations, cancellations, releases and reallocation;
11. fallback and human escalation if the automated path fails;
12. measurable outcome fields for confirmed attendance, cancellations, no-shows, released places and successfully reallocated places.

## Governance baseline

The default governance rule is:

- reminders and non-binding attendance prompts may be automated where the organisation has a valid communication basis and the channel permits it;
- an agent may interpret an explicit user message such as a cancellation request;
- cancellation, release, transfer, refund or another consequential ticket action requires a clear, attributable user instruction or a separately documented authorised rule;
- silence, inferred travel difficulty, calendar conflicts or behavioural predictions must not be treated as consent to cancel;
- capability to call an API or ticketing function is not permission to execute it.

Stricter ticketing, contractual, legal or customer rules override this baseline.

## Measurement model

Where comparable data is available, report:

- booked / registered places;
- attendance confirmations;
- explicit cancellations;
- no-shows;
- released places;
- reallocated places;
- attendance rate;
- no-show rate;
- release-to-reallocation rate;
- intervention window and channel;
- baseline period and re-test period.

Do not claim causality from a single before/after observation where other material factors changed.

## Recommended test design

Use:

**Baseline → defined intervention → re-test → comparison**

Examples of interventions include a confirmation reminder, simpler cancellation path, waiting-list activation or an authorised agent-assisted release workflow.

The analysis must distinguish:

- structural readiness;
- implemented workflow;
- authorised test result;
- observed business outcome.

## Deliverable

For applicable Full Analyses, provide:

- integration map for ticketing / registration / communication systems;
- attendance-conversion risk findings;
- proposed reminder and confirmation workflow;
- cancellation / release / waiting-list logic;
- Agent Governance matrix for allowed, conditional and prohibited actions;
- measurement plan for baseline and re-test;
- implementation brief for the customer, ticketing provider, hoster or developer.

TH Analytica may analyse and specify the workflow without operating the customer's ticket platform. Live execution tests require explicit customer authorisation.

## Reporting language

Do not promise lower no-shows, higher attendance, additional ticket sales or revenue. Report structural readiness and observed test outcomes separately.

