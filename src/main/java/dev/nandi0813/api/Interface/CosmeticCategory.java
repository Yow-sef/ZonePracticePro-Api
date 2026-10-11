package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * A cosmetics category button in the cosmetics hub. Implemented by addons and registered with
 * {@link CosmeticsRegistry#register(org.bukkit.plugin.Plugin, CosmeticCategory)}.
 */
public interface CosmeticCategory {

    /**
     * Unique id, lowercase [a-z0-9_-], e.g. "myaddon_pets".
     * @return The id, never null
     */
    String getId();

    /**
     * Button icon for this viewer; return null to hide the category for them. Called on the main thread.
     * @param player The viewer
     * @return The icon, or null to hide the category
     */
    ItemStack getIcon(Player player);

    /**
     * Called on the main thread when the viewer clicks the button. Typically opens the addon's own GUI.
     * @param player The viewer
     */
    void onClick(Player player);

    /**
     * Lower values are placed first. Ties keep registration order.
     * @return The priority, 0 by default
     */
    default int getPriority() {
        return 0;
    }

}
