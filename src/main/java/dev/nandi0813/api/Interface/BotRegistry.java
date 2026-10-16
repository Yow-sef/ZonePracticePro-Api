package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Connects a bot addon to ZonePractice Pro. One {@link BotProvider} can be registered at a time.
 * Main thread only.
 */
public interface BotRegistry {

    /**
     * Register the bot provider.
     * @param owner The plugin that owns the provider
     * @param provider The provider
     * @throws IllegalStateException if a provider is already registered
     * @throws IllegalArgumentException if the provider id is invalid
     */
    void register(Plugin owner, BotProvider provider);

    /**
     * Unregister a provider. Its active bot matches end.
     * @param provider The provider
     * @return true if the provider was registered
     */
    boolean unregister(BotProvider provider);

    /**
     * Unregister the provider of a plugin. Called automatically by the core when {@code owner} is disabled.
     * @param owner The plugin
     */
    void unregisterAll(Plugin owner);

    /**
     * @return The registered provider, or null
     */
    BotProvider getProvider();

    /**
     * @return true if a provider is registered and available, and the core is ready
     */
    boolean isAvailable();

    /**
     * Open the bot practice ladder, arena and round selection. The match starts with {@code options}.
     * If bot practice is unavailable or the player is busy, the player is told why instead.
     * @param player The player
     * @param options The bot options chosen by the player
     */
    void openSetup(Player player, BotOptions options);

    /**
     * Start a bot practice match. If it cannot start, the player is told why.
     * @param player The player
     * @param setup The ladder, arena, rounds and bot options
     * @return null on success, otherwise an error key, for example UNAVAILABLE, INVALID-SETUP, BUSY, CAPACITY,
     *         NO-ARENA or FAILED
     */
    String start(Player player, BotSetup setup);

    /**
     * The last bot practice setup the player can start again, for example for a rematch.
     * Expires 1200 ticks after the match ends.
     * @param player The player
     * @return The setup, or null
     */
    BotSetup getLastSetup(Player player);

    /**
     * Reserve a new UUID as a bot identity, for a body spawned outside bot matches.
     * Profiles, statistics and lobby handling ignore it until it is released.
     * @param owner The plugin that spawns the body
     * @return The reserved UUID
     */
    UUID reserveEntityId(Plugin owner);

    /**
     * Release a UUID reserved with {@link #reserveEntityId(Plugin)}, after its body was removed.
     * @param entityId The UUID
     */
    void releaseEntityId(UUID entityId);

    /**
     * @param entityId An entity UUID
     * @return true if the UUID belongs to a bot body
     */
    boolean isBot(UUID entityId);

}
