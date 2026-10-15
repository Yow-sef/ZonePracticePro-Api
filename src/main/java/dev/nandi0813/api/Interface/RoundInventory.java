package dev.nandi0813.api.Interface;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;
import java.util.UUID;

/**
 * Snapshot of a player's inventory taken when a round ended (or when the player died in it). Main thread only.
 * @since 2.6.0
 */
public interface RoundInventory {

    /**
     * Get the player the snapshot belongs to.
     * @return The player's unique id, never null
     */
    UUID getPlayerUuid();

    /**
     * Get the round number.
     * @return The round number, 1-based
     */
    int getRoundNumber();

    /**
     * Get the full player inventory contents (storage, armor and off-hand slots, same layout as
     * PlayerInventory#getContents()). Empty slots are null. Returns a fresh copy on every call.
     * @return The inventory contents
     */
    ItemStack[] getContents();

    /**
     * Get the armor contents, boots to helmet. Empty slots are null. Returns a fresh copy on every call.
     * @return The armor contents
     */
    ItemStack[] getArmor();

    /**
     * Get the health at the end of the round.
     * @return The health, 0 if the player died in the round
     */
    double getHealth();

    /**
     * Get the food level at the end of the round.
     * @return The food level
     */
    double getHunger();

    /**
     * Get the active potion effects at the end of the round.
     * @return An unmodifiable list of potion effects
     */
    List<PotionEffect> getPotionEffects();

}
