# InkSDK contributor guide

Read README.md and docs/devices/bigme/INK-WRITING-GUIDE.md before native ink changes.
Neutral contracts: foundation/device-api. Public Android implementation: devices/standard.
Vendor behavior/reflection: devices/bigme only. Keep applications and notebook models out of this
SDK. No sibling dependencies, certificates, user data or generated APKs. Owner tests real devices;
unit tests/builds do not establish latency, palm rejection or panel acceptance.
