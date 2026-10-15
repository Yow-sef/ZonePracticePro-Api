package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Thread-safe. Registered decorators are applied to every rendered player name.
 */
public interface NameDecorationRegistry {

    /**
     * Register a name decorator.
     * @param owner The plugin that owns the decorator
     * @param decorator The decorator
     * @throws IllegalArgumentException if the id is already registered or invalid.
     */
    void register(Plugin owner, NameDecorator decorator);

    /**
     * Unregister a name decorator.
     * @param id The decorator id
     * @return true if a decorator with this id was registered
     */
    boolean unregister(String id);

    /**
     * Unregister every decorator of a plugin.
     * Called automatically by the core when {@code owner} is disabled.
     * @param owner The plugin
     */
    void unregisterAll(Plugin owner);

    /**
     * Unmodifiable snapshot, ordered by priority.
     * @return The registered decorators, never null
     */
    List<NameDecorator> getDecorators();

    /**
     * Re-render the player's nametag and tab name, e.g. after a decorator's output changed.
     * Sidebar and chat pick up changes automatically. Main thread only.
     * @param player The player
     */
    void refresh(Player player);

}
