# ZonePracticePro-Api

API for addons of the ZonePractice Pro plugin.

## 2.4.0

New in 2.4.0 (`ZonePracticeApi.API_VERSION = 3`):

- Player state lookup (`getPlayerState`) and `PlayerStateChangeEvent`.
- Lookups for the match, spectated match, FFA, event, party and queue of a player.
- Ladder names, ladder kills and ladder deaths.
- `FightDeathEvent`, `KitAppliedEvent`, `EloChangeEvent`, `HotbarApplyEvent` and `ZonePracticeReadyEvent`.
- Addon cosmetics categories (`CosmeticsRegistry`) and addon hotbar items (`HotbarItemRegistry`).

All new events are synchronous (main thread) and not cancellable.

### Feature detection

```java
if (ZonePracticeApi.isAvailable() && ZonePracticeApi.API_VERSION >= 3) {
    // 2.4.0 features are available
}
```

### Addon example

```java
public final class MyAddon extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        if (!ZonePracticeApi.isAvailable() || ZonePracticeApi.API_VERSION < 3) {
            getLogger().warning("ZonePractice Pro with API 2.4.0+ is required.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        ZonePracticeApi api = ZonePracticeApi.getInstance();

        // A button in the cosmetics hub.
        api.getCosmeticsRegistry().register(this, new CosmeticCategory() {
            @Override
            public String getId() {
                return "myaddon_pets";
            }

            @Override
            public ItemStack getIcon(Player player) {
                return player.hasPermission("myaddon.pets") ? new ItemStack(Material.BONE) : null;
            }

            @Override
            public void onClick(Player player) {
                player.sendMessage("Opening pets...");
            }
        });

        // An item in slot 4 of the lobby hotbar.
        api.getHotbarItemRegistry().register(this, new HotbarItem() {
            @Override
            public String getId() {
                return "myaddon_stats";
            }

            @Override
            public HotbarLayout getLayout() {
                return HotbarLayout.LOBBY;
            }

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem(Player player) {
                return new ItemStack(Material.BOOK);
            }

            @Override
            public void onUse(Player player) {
                player.sendMessage("Your stats...");
            }
        });

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

Registered categories and items are removed automatically when your plugin is disabled.
