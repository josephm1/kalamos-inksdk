# Kalamos InkSDK

Private, reusable Android pen input and rendering modules extracted from the current Kalamos
Notes implementation. Notes already uses these same module contracts/providers. This is a source
SDK, not AndroidX Ink or a manufacturer SDK, and does not include Notes' notebook/editor engine.

## Modules

- `foundation/device-api`: DeviceProvider/DeviceRegistry, InkController/InkEditingController,
  stroke callbacks/points, style defaults and ink diagnostics.
- `devices/standard`: public Android MotionEvent stylus input, coalesced history and pressure,
  SurfaceView rendering, bounded writing/exclusions and editing capture.
- `devices/bigme`: separate optional Bigme daemon/e-ink provider. It uses device firmware APIs
  through reflection and hidden-API bypass; do not package it for a generic tablet.

Host applications own their surface, document identity, save/undo, selection semantics and lifecycle.
The SDK has no Markdown, AI, API credentials, notebook files or app-to-app integration. KOReader's
NativeActivity adapter lives in the separate kalamos-koreader repository.

## Build

Use JDK17 and Android SDK34. Set `ANDROID_HOME`, or an untracked `local.properties` with sdk.dir.

```sh
./gradlew :devices:standard:assembleDebug :devices:standard:testDebugUnitTest
./gradlew :devices:bigme:assembleDebug :devices:bigme:testDebugUnitTest
./gradlew :foundation:device-api:testDebugUnitTest
```

Each selected module emits an AAR under its build/outputs/aar directory. Consume the API and
**one** provider as Gradle modules, or package those AARs with their declared external dependencies.
The provider manifest supplies DeviceRegistry metadata; merging two provider modules into one
application is an error. Generic tablets need the standard provider only.

## Host integration

```kotlin
val provider = DeviceRegistry.require(context)
val ink = provider.createInkController()
// Wait until the SurfaceView has its final nonzero dimensions and a valid Surface.
val attached = ink.attach(surface, Rect(0, 0, surface.width, surface.height), callback)
ink.setStrokeStyle(3f, Color.BLACK)
// Supply the authoritative retained page before enabling writing.
ink.syncOverlay(pageBitmap)
// Pause input for a model/presentation transaction; detach when the host stops.
ink.setEnabled(false)
ink.detach()
```

Callbacks and surfaces use view-local physical pixels. Standard Android produces incremental
begin/move/end samples; a hardware provider may produce begin plus onStrokeComplete. A host must
normalize the provider's delivery without saving a gesture twice. Optional InkEditingController
supports capture-only eraser/lasso paths, per-contact decisions, excluded control contacts and
cropped chrome updates. Ordinary Android surfaces already own their visible pixels; daemon
visibility/waveform behavior stays in the Bigme provider.

NativeActivity hosts have an independent native input queue. They must forward owned stylus
MotionEvents when requiresMotionForwarding is true; normal View hosts already receive them.
Do not deliver one contact through both paths. The modified KOReader demonstrates this adapter.

## Limits and licensing

Public stylus features depend on hardware/firmware reporting standard Android input. This does not
guarantee low-latency vendor modes on every e-ink tablet or universal palm/eraser support. Physical
latency, pressure, lifecycle and panel acceptance belong to the owner. See module LICENSE/NOTICE
files for AGPL-3.0-or-later and third-party terms. Keep this repository private.
