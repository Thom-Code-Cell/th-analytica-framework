# LLM Discovery / Locale Resolution

Status: TH Analytica Framework module  
Version: 1.0  
Updated: 2026-09-20

## Purpose

This module checks whether optional LLM discovery files are exposed consistently across the languages a website actually advertises.

It is an evidence and diagnostics module. It does not treat `llms.txt` as a universal standard, a ranking factor, proof of retrieval, proof of training, or proof of AI visibility.

## Scope

The assessment starts with the canonical site and the language variants explicitly advertised through `hreflang`, canonical links, sitemaps and real public routes.

It must not invent or require language variants that the organisation does not actually publish.

## Required checks

### 1. Root discovery file

Check the canonical `/llms.txt` and record:

- requested and final URL
- HTTP status
- content type
- content length
- whether the response is real text or an HTML soft fallback
- basic content quality: useful, thin or missing
- `Last-Modified` when the server provides it

### 2. Locale resolution

For every advertised language variant, derive and test the relevant locale path, for example:

- `/en/llms.txt`
- `/fr/llms.txt`
- `/it/llms.txt`

Candidate paths may be derived from the actual first path segment and the advertised language tag. Redirects must be followed and the final URL documented.

### 3. Cross-check

Compare discovery paths with:

- real language pages
- `hreflang`
- canonical URLs
- XML sitemaps
- the central `/llms.txt`

A language-specific discovery file should not claim content, markets or services that are absent from the corresponding public language experience.

### 4. Failure modes

Record separately:

- 200 with useful text
- 200 with thin text
- redirect to a valid text file
- 404/410
- timeout or blocked access
- HTML soft-404 or SPA fallback
- locale advertised but no locale discovery path available

## Scoring rule

The existence of `llms.txt`, `ai.txt` or another proprietary discovery file must not add readiness points merely because the file exists.

Locale resolution is reported as a diagnostic quality and consistency finding. Established access, semantic and governance signals remain scored under their respective framework controls.

## Interpretation

A missing `llms.txt` or locale variant does not prove that a website is invisible to AI systems. A successful fetch does not prove that an AI provider processes, cites, mentions or recommends the site.

When server or CDN logs are available, observed bot requests may be reported as separate evidence. Log access must not be inferred from public website checks.

## Full-analysis reporting

Every full analysis of a multilingual website should include:

1. root `llms.txt` status
2. advertised language variants
3. locale-path status per language
4. hreflang/canonical/sitemap consistency
5. freshness evidence where available
6. soft-fallback or redirect anomalies
7. recommended fixes
8. an explicit statement that the module does not measure actual downstream AI recommendation

For monolingual websites, the module records the root discovery state and marks locale expansion as not applicable unless additional language variants are actually advertised.
