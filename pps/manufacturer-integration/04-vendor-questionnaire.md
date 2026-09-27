# PPS vendor technical questionnaire

## Platform
1. At which layer could nearby BLE service data be observed: firmware, OS, companion app, third-party app, or not currently available?
2. Can that layer react before or during camera/audio capture?
3. Can scene-level processing rules be changed without identifying a person in the frame?
4. Which PPS DENY categories can the product technically enforce today?

## Privacy and telemetry
5. Would PPS detection require cloud processing?
6. Would rotating tokens be logged? If yes, where and for how long?
7. Can logs avoid turning PPS tokens into persistent identifiers?
8. Is there an existing privacy-event or policy engine that could accept PPS as an input?

## Security
9. How should repeated or spoofed nearby signals be handled without weakening privacy?
10. Are there platform attestation mechanisms that could support future unlinkable anti-abuse work?
11. What safety-critical functions must remain exempt from PPS restrictions?

## Developer path
12. Is a proof of concept possible through an existing SDK/toolkit?
13. What API or firmware boundary prevents fuller support today?
14. What evidence would your engineering/privacy team require before a deeper pilot?

Technical contact: thomas@th-analytica.com
