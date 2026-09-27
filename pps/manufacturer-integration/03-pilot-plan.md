# Limited PPS manufacturer pilot

## Objective

Determine whether a manufacturer platform can discover, parse and safely react to PPS Draft v1.0 without requiring a public product commitment.

## Suggested scope

One device family or developer platform, one controlled receiver implementation and the TH Analytica Android PPS reference sender.

## Phases

### 1. Parser validation
- ingest the public test vectors;
- validate version, level, flags and token;
- verify malformed and unknown-version behavior.

### 2. BLE discovery
- detect service data from the reference sender;
- measure discovery latency and missed detections;
- test ordinary orientation/interference conditions.

### 3. Policy mapping
Map only genuinely supported PPS flags to real product controls. Record unsupported flags rather than implying enforcement.

### 4. Collective Privacy Shield experiment
Where technically possible, apply a scene-level privacy response without identifying the transmitter.

### 5. Recovery
Verify predictable restoration after the PPS signal expires or disappears.

### 6. Security review
Document spoofing, replay and denial-of-service exposure without solving them by introducing a persistent personal identifier.

## Suggested metrics
- discovery latency;
- packet acceptance/rejection accuracy;
- recovery latency;
- battery/CPU impact;
- user-visible state accuracy;
- number of PPS flags genuinely enforceable;
- privacy/security exceptions.

## Exit criterion

A successful pilot proves feasibility for the tested build only. It does not automatically grant the official `Personal Privacy Signal Compatible` designation and does not imply product launch.
