## 21 October 2026 — Per-client delayed overlay replay disabled

Synced the small Bigme provider fix verified by the Notes owner: disable the optional firmware
idle recommit immediately after connect, before activating input/overlay. Notes already owns the
local erase refresh; the service's independent replay caused a later whole-panel flash. The owner
confirmed the flash stopped with the updated Notes build. Input gating, package display policy,
waveforms, capture cadence and other apps' clients remain unchanged. Missing optional firmware
API logs a warning without preventing writing. No Notes app/model code is included in this SDK.
Other devices/firmware and other host applications retain their own physical acceptance needs.

## Upstream attribution and ink licensing — 19 October 2026

Added prominent original-project credit and licence scope. Ink modules now use GPL-3.0-only;
Ed Wei's original InkSDK is credited in module notices and docs/licensing/INKSDK.md. Original
reader plugin/bridge AGPL and launcher/JNI MIT notices remain separate. Complete licence texts
and dependency attributions are included. Licensing/documentation changes only; no pen behavior,
refresh policy, binary build or device acceptance change.

## Public audit — 19 October 2026

Owner authorized public visibility after auditing source and history. No API credentials, private
keys, machine paths, app certificates, user notebooks or books found in published inputs. Git
email metadata normalized to the owner's GitHub privacy address. Source manifest refreshed.
No app code, local configuration or generated AAR/APK is included. Existing module licenses and
third-party notices retained. SDK sources remain independent of the private Notes repository.

# Source publication — 19 October 2026

User initially requested separate private repositories for maintained KOReader plugins and the reusable
InkSDK currently integrated into Kalamos Notes. Extracted selected canonical modules without app
sources, licensed app certificates, personal material or sibling repository dependencies. See
README.md for host/module boundaries and VERIFICATION.md for automated checks. User owns
on-device acceptance. Future code edits should retain module ownership and source manifests.
