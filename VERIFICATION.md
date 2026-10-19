# Source verification — 19 October 2026

Standalone source; no sibling checkout, private notebooks, API credentials or certificates.

Independent AAR builds and native unit tests pass:device-api15, Standard6, Bigme21 (42 total,
zero failures/errors/skips). Includes five new Standard graphics/input tests for capture-only,
per-gesture ownership, excluded controls, cropped chrome preservation and transparent resets.
Standard uses public Android stylus input. Bigme method behavior/cadence remains device-owned.
The extracted source is the same selected API/providers used by current Notes and modified reader.
Generic KOReader transport and source packaging are tested separately in kalamos-koreader.
This is source SDK publication, not a device acceptance claim or Maven release.
