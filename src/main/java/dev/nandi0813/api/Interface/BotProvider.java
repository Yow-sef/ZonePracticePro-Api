package dev.nandi0813.api.Interface;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * Supplies bot opponents to ZonePractice Pro. Register it with {@link BotRegistry#register}.
 * The core calls every method on the main thread.
 */
public interface BotProvider {

    /**
     * Unique id, lowercase [a-z0-9-], 1-32 characters, e.g. "zpp-bots".
     * @return The id, never null
     */
    String getId();

    /**
     * @return true if bots can be spawned right now
     */
    boolean isAvailable();

    /**
     * Why the provider is unavailable, for the console and admins.
     * @return The reason, or null if available
     */
    String getUnavailableReason();

    /**
     * Options used when no player choice exists, for example from staff commands.
     * @return The options, never null
     */
    BotOptions getDefaultOptions();

    /**
     * Command without the slash that lets a player choose new options, e.g. "botpractice".
     * The result message after a bot match offers it, and offers it with the argument {@code rematch},
     * which should start {@link BotRegistry#getLastSetup(org.bukkit.entity.Player)} again.
     * @return The command, never null; lowercase letters, digits, underscores and hyphens, at most 32 characters
     */
    String getSetupCommand();

    /**
     * Whether bots can fight with this kit item. A ladder whose kit holds an unsupported item cannot host bot matches.
     * @param item A non-air kit item, a copy the provider may inspect but not keep
     * @return true if the bot can use the item
     */
    boolean isSupportedItem(ItemStack item);

    /**
     * Spawn a paused bot body. The core has already reserved {@code entityId} as a bot identity.
     * @param entityId The UUID the body must use
     * @param location The spawn location, inside a loaded arena
     * @param options The options chosen for this match
     * @return The spawned opponent
     * @throws RuntimeException If spawning fails; nothing may be left behind
     */
    BotOpponent spawn(UUID entityId, Location location, BotOptions options);

}
