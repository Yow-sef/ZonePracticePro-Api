package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/**
 * Thread-safe registration. If a slot is already used by a built-in item of that layout, the addon item is skipped
 * and the core logs one warning per id. Addon items cannot be dropped or moved, the same as built-in items.
 */
public interface HotbarItemRegistry {

    /**
     * Register a hotbar item.
     * @param owner The plugin that owns the item
     * @param item The item
     * @throws IllegalArgumentException if the id is already registered or invalid, or the slot is out of 0-35.
     */
    void register(Plugin owner, HotbarItem item);

    /**
     * Unregisters and removes the item from every online player currently holding it.
     * @param id The item id
     * @return true if an item with this id was registered
     */
    boolean unregister(String id);

    /**
     * Unregister every item of a plugin.
     * Called automatically by the core when {@code owner} is disabled.
     * @param owner The plugin
     */
    void unregisterAll(Plugin owner);

    /**
     * Re-applies addon items of the player's current layout: gives missing ones, removes ones whose getItem now
     * returns null. Main thread only.
     * @param player The player
     */
    void refresh(Player player);

    /**
     * Get the addon item id of an item stack.
     * @param itemStack The item stack, nullable
     * @return the registered id of an addon hotbar item, or null if the stack is not one.
     */
    String getItemId(ItemStack itemStack);

}
