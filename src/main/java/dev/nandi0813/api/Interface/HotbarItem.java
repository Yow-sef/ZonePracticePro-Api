package dev.nandi0813.api.Interface;

import dev.nandi0813.api.Enum.HotbarLayout;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * An addon item in a core hotbar layout. Implemented by addons and registered with
 * {@link HotbarItemRegistry#register(org.bukkit.plugin.Plugin, HotbarItem)}.
 */
public interface HotbarItem {

    /**
     * Unique id, lowercase [a-z0-9_-].
     * @return The id, never null
     */
    String getId();

    /**
     * The layout this item belongs to.
     * @return The layout, never null
     */
    HotbarLayout getLayout();

    /**
     * Player inventory slot, 0-35 (0-8 = hotbar).
     * @return The slot
     */
    int getSlot();

    /**
     * Item for this player; return null to not give it to them (e.g. permission check). Called on the main thread.
     * @param player The player
     * @return The item, or null to not give it
     */
    ItemStack getItem(Player player);

    /**
     * Called on the main thread when the player right-clicks with the item in hand.
     * @param player The player
     */
    void onUse(Player player);

}
