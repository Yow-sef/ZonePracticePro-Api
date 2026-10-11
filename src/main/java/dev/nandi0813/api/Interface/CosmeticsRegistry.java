package dev.nandi0813.api.Interface;

import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Thread-safe. Registered categories appear below the built-in buttons of the cosmetics hub, 7 per row, up to 21.
 * Additional categories are ignored, and the core logs a warning.
 */
public interface CosmeticsRegistry {

    /**
     * Register a cosmetics category.
     * @param owner The plugin that owns the category
     * @param category The category
     * @throws IllegalArgumentException if the id is already registered or invalid.
     */
    void register(Plugin owner, CosmeticCategory category);

    /**
     * Unregister a cosmetics category.
     * @param id The category id
     * @return true if a category with this id was registered
     */
    boolean unregister(String id);

    /**
     * Unregister every category of a plugin.
     * Called automatically by the core when {@code owner} is disabled.
     * @param owner The plugin
     */
    void unregisterAll(Plugin owner);

    /**
     * Unmodifiable snapshot, ordered by priority.
     * @return The registered categories, never null
     */
    List<CosmeticCategory> getCategories();

}
