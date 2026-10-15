# ZonePracticePro API

Public API for addons of the ZonePractice Pro plugin: interfaces, enums and events, without internal plugin classes.

[![JitPack](https://jitpack.io/v/ZoneDevelopement/ZonePracticePro-Api.svg)](https://jitpack.io/#ZoneDevelopement/ZonePracticePro-Api) [![Build](https://github.com/ZoneDevelopement/ZonePracticePro-Api/actions/workflows/build.yml/badge.svg)](https://github.com/ZoneDevelopement/ZonePracticePro-Api/actions/workflows/build.yml)

- [Developer docs](https://zone-developement.gitbook.io/zonepractice-pro/extra/for-developers)
- [Javadoc (latest)](https://zonedevelopement.github.io/ZonePracticePro-Api/latest/)
- [Changelog](CHANGELOG.md)

## Installation

Gradle (Kotlin):

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.ZoneDevelopement:ZonePracticePro-Api:2.5.1")
}
```

Maven:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.ZoneDevelopement</groupId>
    <artifactId>ZonePracticePro-Api</artifactId>
    <version>2.5.1</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

Add the dependency to `plugin.yml`:

```yaml
depend: [ZonePracticePro]
```

## Quick start

```java
public final class MyAddon extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        if (!ZonePracticeApi.isAvailable() || ZonePracticeApi.API_VERSION < 4) {
            getLogger().warning("A ZonePractice Pro version with API 2.5.0+ is required.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onFightDeath(FightDeathEvent event) {
        if (event.hasKiller()) {
            event.getKiller().sendMessage("You killed " + event.getVictim().getName()
                    + " on " + event.getLadderName());
        }
    }

}
```

Use `ZonePracticeApi.getInstance()` to call the API, for example `ZonePracticeApi.getInstance().getPlayerState(player)`.

## Releasing

For maintainers:

1. Write commits with Conventional Commits (`feat:`, `fix:`, `docs:`, ...). They become the changelog.
2. Bump `version` in `build.gradle.kts`, and `ZonePracticeApi.API_VERSION` for additive changes. Push to `master`.
3. The Release workflow tags the version, publishes the GitHub release "ZonePracticePro API x.y.z" with the notes and jars, updates `CHANGELOG.md`, verifies the JitPack build and publishes the javadoc.

To run the release again, open Actions, choose Release and click Run workflow.
