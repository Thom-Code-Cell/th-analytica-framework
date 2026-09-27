# PPS Draft v1.0 baseline

Status: frozen technical baseline reference
Baseline date: 2026-09-27

The governance-hardened PPS Draft v1.0 baseline is anchored at Git commit:

`445caad6b225a6df01ba4f66a051089b0b6c07c5`

For convenience, the repository also contains the branch `pps-draft-v1.0-baseline`.

The commit SHA, not the branch name, is the authoritative immutable reference.

Wire-format baseline:
- BLE Service Data
- PoC UUID `7b2f4d10-9a6e-4ce7-8b7f-6d5050530001`
- exactly 8 payload bytes
- byte 0: protocol version
- byte 1: privacy level
- byte 2: DENY flags
- byte 3: reserved
- bytes 4-7: rotating unsigned 32-bit token, big-endian

Reference MAXIMUM values:
- version `0x01`
- level `0x03`
- DENY flags `0x7F`
- reserved `0x00`

Example token `0x01020304`: `01 03 7F 00 01 02 03 04`

This is a Draft baseline, not a final industry standard and not a claim that commercial third-party devices implement PPS.
