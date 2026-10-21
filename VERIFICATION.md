# Source verification — 19 October 2026

Standalone source; no sibling checkout, private notebooks, API credentials or certificates.

Independent AAR builds and native unit tests pass:device-api15, Standard6, Bigme21 (42 total,
zero failures/errors/skips). Includes five new Standard graphics/input tests for capture-only,
per-gesture ownership, excluded controls, cropped chrome preservation and transparent resets.
Standard uses public Android stylus input. Bigme method behavior/cadence remains device-owned.
The extracted source is the same selected API/providers used by current Notes and modified reader.
Generic KOReader transport and source packaging are tested separately in kalamos-koreader.
This is source SDK publication, not a device acceptance claim or Maven release.

## Attribution update — 19 October 2026

Documentation/licence-only update: upstream credits, full licence texts and component scopes
checked. Ink modules are GPL-3.0-only; reader AGPL and launcher/JNI MIT terms stay separate.
No runtime source changed; previous behavior/build results above remain historical evidence.

## Delayed overlay replay — 21 October 2026

Standalone Bigme AAR build and all 23 provider tests pass after synchronizing the per-client
idle-recommit fix used by Notes. The same provider source was installed with Notes and the owner
confirmed the reported delayed scribble-erase flash stopped. This is physical acceptance for that
Notes/Bigme regression, not blanket acceptance for every host or firmware. Neutral API and Standard
provider source are unchanged. No additional application installation is required for this export.
