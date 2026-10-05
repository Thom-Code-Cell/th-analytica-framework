# HTC VIVE Eagle — PPS application-level feasibility study

Status: Experimental interoperability study  
Verified: 2026-10-05  
Maintainer: Thomas Hullin / TH Analytica

This document is a vendor-specific engineering study for Personal Privacy Signal
(PPS). It does **not** state or imply that HTC has adopted, endorsed, certified or
partnered with PPS.

## Why VIVE Eagle is relevant

HTC has publicly designed VIVE Eagle around visible capture privacy controls.
Official VIVE support states that video recording is unavailable if the capture
LED is covered or if the glasses are not worn.

HTC also publishes the VIVE AI Glasses SDK for Android and iOS. The developer
documentation identifies VIVE Eagle as compatible and exposes camera and
streaming functions to registered third-party applications.

Sources:

- VIVE AI Glasses SDK:
  https://developer.vive.com/resources/vive-ai-glasses-sdk/
- Android SDK documentation:
  https://developer.vive.com/resources/vive-ai-glasses-sdk/documentation/android/
- Android setup:
  https://developer.vive.com/resources/vive-ai-glasses-sdk/documentation/android/setup/
- Image capture:
  https://developer.vive.com/resources/vive-ai-glasses-sdk/documentation/android/viveglass/captureimage/
- Video streaming:
  https://developer.vive.com/resources/vive-ai-glasses-sdk/documentation/android/viveglass/startvideostreaming/
- VIVE Eagle recording privacy behavior:
  https://www.vive.com/eu/support/vive-eagle/category_howto/recording-videos.html
- HTC privacy article:
  https://www.vive.com/us/newsroom/2026-09-09-2/

## Complementary privacy directions

VIVE Eagle's capture LED communicates:

```
device -> nearby human: capture is active
```

PPS proposes the complementary machine-readable direction:

```
nearby person/place -> device/application: privacy preference is active
```

A PPS integration can therefore complement rather than replace a visible
recording indicator.

## Smallest useful proof of concept

The most realistic public-SDK experiment is application-level:

1. Android application scans for PPS Draft v1.0 BLE service data.
2. It validates the packet and maintains the normal PPS TTL/hysteresis state.
3. It connects to VIVE Eagle using the official VIVE AI Glasses SDK.
4. Before `captureImage()` or `startVideoStreaming()`, it checks whether the
   supported PPS rule denies capture/audio.
5. If capture is denied, the application does not start capture.
6. If an application-owned stream is already active when a valid capture DENY
   appears, the application calls `stopVideoStreaming()`.
7. It provides a truthful local privacy-state indication to the wearer.
8. It restores ordinary behavior only after the PPS condition expires.

## Important boundary

This experiment would demonstrate PPS enforcement only inside the PPS-aware
application.

It would **not** demonstrate that:

- VIVE Eagle firmware enforces PPS;
- native VIVE capture is globally disabled;
- other applications are blocked;
- HTC has implemented PPS;
- a user cannot bypass the application by using another capture path.

Those stronger claims require a documented HTC platform/firmware integration.

## Candidate application logic

```kotlin
fun requestImage() {
    if (ppsState.deniesCapture()) {
        showPrivacyState()
        return
    }
    viveGlass.captureImage(imageQuality)
}

fun requestStream() {
    if (ppsState.deniesCapture() || ppsState.deniesAudio()) {
        showPrivacyState()
        return
    }
    viveGlass.startVideoStreaming(...)
}

fun onPpsStateChanged(state: PpsState) {
    if (state.deniesCapture() && viveGlass.isVideoStreaming()) {
        viveGlass.stopVideoStreaming()
        showPrivacyState()
    }
}
```

This is illustrative integration logic, not HTC production code.

## Engineering questions for a deeper integration

A platform-level evaluation should establish:

1. whether PPS scanning can run continuously alongside the VIVE SDK connection;
2. whether stopping an SDK stream immediately releases all app-owned
   camera/microphone resources;
3. whether native capture events are observable by third-party applications;
4. whether HTC exposes a device-policy or privileged privacy-control API;
5. how a wearer-visible privacy state should be presented;
6. what anti-spoofing and denial-of-service protections HTC would require;
7. whether a future PPS/PPS+ policy could be evaluated below the application
   layer.

## Compatibility wording

Until HTC explicitly implements and validates PPS, the correct wording is:

> "PPS feasibility study for HTC VIVE Eagle using public SDK surfaces."

Do not use "PPS Compatible", "HTC supports PPS" or any partnership language.
