pluginManagement { repositories { google(); mavenCentral(); gradlePluginPortal() } }
dependencyResolutionManagement { repositories { google(); mavenCentral() } }
rootProject.name = "kalamos-inksdk"
include(":foundation:device-api", ":devices:standard", ":devices:bigme")
