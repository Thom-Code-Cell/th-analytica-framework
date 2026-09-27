# PPS Draft v1.0 conformance test suite

This directory defines the public, implementation-neutral conformance vectors for PPS Draft v1.0.

## Canonical wire checks

1. Payload length must be exactly 8 bytes.
2. Protocol version must be 1 for Draft v1.0.
3. MAXIMUM privacy level is 3.
4. Seven DENY bits produce `0x7F`.
5. Reserved byte is `0x00` for a canonical sender.
6. Reserved flag bit 7 remains clear.
7. Token is an unsigned 32-bit value encoded big-endian.
8. Unknown versions and malformed payloads must not be interpreted as valid Draft v1.0 signals.

## Canonical positive vector

Token `0x01020304`:

`01 03 7F 00 01 02 03 04`

Expected fields:
- version 1
- level 3 / MAXIMUM
- flags 127 / `0x7F`
- reserved 0
- token 16909060

## Negative vectors

- unknown version: `02 03 7F 00 01 02 03 04`
- short payload: `01 03 7F 00 01 02 03`
- long payload: `01 03 7F 00 01 02 03 04 00`
- non-zero reserved byte: `01 03 7F 01 01 02 03 04`
- reserved flag bit 7: `01 03 FF 00 01 02 03 04`

## Full conformance requires device evidence

Wire parsing alone does not prove token rotation, Bluetooth behavior, unlinkability, user-interface truthfulness, Collective Privacy Shield behavior, anti-spoofing, replay resistance or legal compliance.

The official full-project designation is `Personal Privacy Signal Compatible`, not the stand-alone wording `PPS Compatible`.
