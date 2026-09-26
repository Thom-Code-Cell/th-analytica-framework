# PPS versioning and release policy

## Status labels

PPS distinguishes protocol number from maturity.

- **Draft**: experimental; fields, UUIDs or semantics may still change.
- **Candidate**: intended for multi-vendor interoperability testing; breaking changes should be exceptional.
- **Stable**: published as a production baseline after security and interoperability review.
- **Deprecated**: still identifiable but no longer recommended for new implementations.

Therefore **PPS Draft v1.0 is not the same thing as PPS Stable 1.0**.

## Version numbers

Protocol versions use MAJOR.MINOR.PATCH for project documentation and releases where useful.

- MAJOR: incompatible wire-format or semantic change.
- MINOR: backward-compatible capability or optional field/behavior.
- PATCH: clarification or correction that does not change interoperability semantics.

The on-air protocol-version field may use a compact mapping documented by the specification.

## Experimental UUID

The current BLE UUID is a proof-of-concept identifier. It must not be represented as an industry-assigned standard UUID.

A future Candidate or Stable release may change transport identifiers if interoperability, allocation or security work requires it.

## Release requirements

A PPS release should include:

- canonical specification version;
- changelog;
- conformance-test version;
- known security limitations;
- migration notes for breaking changes;
- immutable Git commit reference.

Stable releases should be tied to a GitHub release or equivalent immutable publication. Cryptographic signing should be used when the release process supports it. The project must not describe an unsigned artifact as signed.

## Deprecation

A deprecated version remains documented long enough for implementers to identify legacy signals safely. Deprecation must not silently repurpose an old version number.
