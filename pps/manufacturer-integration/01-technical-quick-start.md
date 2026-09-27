# PPS technical quick start

## Transport

BLE Service Data

Experimental Draft v1.0 UUID:
`7b2f4d10-9a6e-4ce7-8b7f-6d5050530001`

## Payload

Exactly 8 bytes, big-endian:

| Byte(s) | Meaning |
|---|---|
| 0 | protocol version |
| 1 | privacy level |
| 2 | DENY flags |
| 3 | reserved |
| 4-7 | rotating unsigned 32-bit token |

Draft v1.0 values:
- version: `1`
- MAXIMUM level: `3`
- DENY capture: bit 0
- DENY audio: bit 1
- DENY facial recognition: bit 2
- DENY biometrics: bit 3
- DENY AI analysis: bit 4
- DENY cloud upload: bit 5
- DENY training: bit 6
- bit 7: reserved

MAXIMUM flags: `0x7F`

Example: `01 03 7F 00 01 02 03 04`

## Receiver minimum behavior

1. discover the PPS service-data UUID;
2. require an 8-byte Draft v1.0 payload;
3. validate the protocol version;
4. parse level, flags and token;
5. do not persistently identify the rotating token;
6. map only supported DENY requests to documented product behavior;
7. document safety/legal exceptions;
8. restore ordinary behavior after the PPS request is no longer applicable;
9. expose truthful user-visible state where appropriate.

Draft v1.0 is not cryptographically authenticated. Receipt is not proof of a person's identity.
