# PPS Android camera-stop test — 30 September 2026

Status: preliminary developer-operated functional demonstration, not independent certification.

## Setup
Operator: Thomas Hullin, TH Analytica.
BLE sender: Samsung Galaxy S10+ (model reported by operator).
Camera receiver: Samsung Galaxy Tab A8 (model reported by operator).
Receiver: PPS Receiver 0.1.0-test, source commit ee7a6abe335afe471312f778701dd667d359562b, package com.thanalytica.pps.receiver.
The supplied receiver build passed four unit tests, assembly and lint (zero lint errors). Installed binary identity was not independently extracted from the device.
Exact Android versions, installed sender version, distance and radio conditions were not recorded.
Scope: BLE Draft v1 restriction handling by this app's own camera. No PPS+ QR decoding or AI processing tested.

## Evidence and provenance
Three runs are visible in operator-supplied screenshots of events.csv:
- 1000035378.jpg: first run.
- 1000035379.jpg: second and third runs.
These are screenshot transcriptions, not fresh original CSV files. The earlier uploaded events.csv contains only scan/release events and does not substantiate these recording runs.
An uploaded video, 1000035373.mp4, was inspected: H.264, 480 x 720, 50.038889 seconds, no audio stream, 23,024,342 bytes. Its size matches run 1; size alone is not cryptographic proof of identity.
Private images/video are not included in this repository.

## Results
Durations use the receiver's monotonic elapsedRealtime timestamps.

| Run | Recording start | Restriction received | Stop requested | Finalized | Receive to stop request | Stop request to finalization | Bytes |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| 1 | 175741670 | 175791820 | 175791824 | 175792850 | 4 ms | 1026 ms | 23024342 |
| 2 | 176938237 | 176940898 | 176940900 | 176941921 | 2 ms | 1021 ms | 1231684 |
| 3 | 177164109 | 177178694 | 177178696 | 177179722 | 2 ms | 1026 ms | 7040186 |

Each run shows pps_received RESTRICT, stop_requested with PPS restriction as cause, record_finalized error=0, and unchanged before/after file size at the later check.
Run 1's explicit stop_ms field is 1025 ms, while event timestamp subtraction gives 1026 ms. Both values are retained. The 1 ms discrepancy may reflect separate measurement/logging instants; its cause was not independently verified.
These intervals do not measure sender activation to reception or the timestamp of the final captured frame. Finalization can include buffered frames.

## Operator-reported checks
On 30 September 2026 Thomas reported:
- Without the protection signal, recording continues (exact duration not documented).
- Activating the signal stops the camera/recording automatically.
- Recording does not automatically restart; manual release/start is required.
The no-signal control and persistent lock are operator observations, not separately established by the supplied log excerpts.

## Interpretation and limits
Three observed runs support a working cooperative BLE-to-camera-stop path on this pair of devices. They do not establish reliability across devices, operating conditions or firmware.
This is not a system-wide camera control, a demonstrated smart-glasses integration, or protection against nonparticipating cameras or hostile drones.
The signal is not an authenticated authorization to disable safety-critical equipment. Such deployments require separate security and safety design.
No exact end-to-end latency, range, battery impact, background operation, anti-spoofing robustness, audio restriction, AI restriction or cloud restriction has been validated here.

## Next step
Ask a manufacturer to identify suitable hardware and a technical contact for a controlled replication. Record OS/app versions and original exported logs in the next round. No hardware purchase is required for the present evidence package.

## Procedure for a controlled replication
1. Use a consenting test scene and keep the PPS sender off.
2. Open the dedicated receiver app, grant camera/BLE permissions and start BLE reception.
3. After at least five seconds without a restrictive packet, manually release the camera and start a local silent recording.
4. Activate the PPS sender with MAXIMUM. Observe the recording stop and export the event log after finalization and the file-size check.
5. Turn the sender off. Confirm there is no automatic restart. After the quiet period, manually release and start a new recording.
6. Repeat and run a no-signal control, recording its duration and termination reason.

The receiver application/source is not distributed by this report. Contact TH Analytica to arrange access for replication; this publication documents the experiment, not a complete independently reproducible software package.

Protocol reference: [Personal Privacy Signal](../../personal-privacy-signal.md).
Contact: thomas@th-analytica.com.
