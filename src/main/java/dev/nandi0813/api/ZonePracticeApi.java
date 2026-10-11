package dev.nandi0813.api;

import dev.nandi0813.api.Enum.DivisionName;
import dev.nandi0813.api.Enum.PlayerState;
import dev.nandi0813.api.Enum.WeightClass;
import dev.nandi0813.api.Interface.CosmeticsRegistry;
import dev.nandi0813.api.Interface.FFA;
import dev.nandi0813.api.Interface.HotbarItemRegistry;
import dev.nandi0813.api.Interface.Match;
import dev.nandi0813.api.Interface.Party;
import dev.nandi0813.api.Interface.Queue;
import dev.nandi0813.api.Utilities.PlayerNametag;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class ZonePracticeApi
{

    /**
     * Incremented on every additive API release. 2.4.0 = 3.
     */
    public static final int API_VERSION = 3;

    /**
     * Use {@link #getInstance()}. Kept for binary compatibility; set by the core plugin only.
     */
    @Deprecated
    public static ZonePracticeApi instance = null;

    public static ZonePracticeApi getInstance() {
        return instance;
    }

    /**
     * Check whether ZonePractice Pro has registered its API implementation.
     * @return true if {@link #getInstance()} returns a non-null instance
     */
    public static boolean isAvailable() {
        return instance != null;
    }

    /**
     * Get the player's division. Main thread only.
     * @param player The player
     * @param divisionName Short or Full name of the division
     * @return The player's division, or null if the player has no loaded profile
     */
    public abstract String getPlayerDivision(Player player, DivisionName divisionName);

    /**
     * Get the amount of unranked matches left for the player. Main thread only.
     * @param player The player
     * @return The amount of unranked matches left, or -1 if the player has no loaded profile
     */
    public abstract int getPlayerUnRankedLeft(Player player);

    /**
     * Get the amount of ranked matches left for the player. Main thread only.
     * @param player The player
     * @return The amount of ranked matches left, or -1 if the player has no loaded profile
     */
    public abstract int getPlayerRankedLeft(Player player);

    /**
     * Reset the player's unranked matches. Does nothing if the player has no loaded profile.
     * Main thread only.
     * @param player The player
     */
    public abstract void resetPlayerUnRanked(Player player);

    /**
     * Reset the player's ranked matches. Does nothing if the player has no loaded profile.
     * Main thread only.
     * @param player The player
     */
    public abstract void resetPlayerRanked(Player player);

    /**
     * Add unranked matches to the player. Does nothing if the player has no loaded profile.
     * Main thread only.
     * @param player The player
     * @param amount The amount of unranked matches to add
     */
    public abstract void addPlayerUnRanked(Player player, int amount);

    /**
     * Add ranked matches to the player. Does nothing if the player has no loaded profile.
     * Main thread only.
     * @param player The player
     * @param amount The amount of ranked matches to add
     */
    public abstract void addPlayerRanked(Player player, int amount);

    /**
     * End the match for the player. Does nothing if the player is not in a match.
     * Main thread only.
     * @param player The player
     * @param endMessage The message to send to the match, in MiniMessage format. Nullable.
     */
    public abstract void endMatch(Player player, String endMessage);

    /**
     * Get the player's elo for a specific ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder
     * @return The player's elo, or -1 if the player has no loaded profile, the ladder name is unknown,
     *         or the ladder is unranked-only
     */
    public abstract int getElo(Player player, String ladder);

    /**
     * Get the player's experience points. Main thread only.
     * @param player The player
     * @return The player's experience, or -1 if the player has no loaded profile
     */
    public abstract int getExperience(Player player);

    /**
     * Get the player's wins for a specific weight class. Main thread only.
     * @param player The player
     * @param ladder The ladder
     * @param weightClass The weight class
     * @return The player's wins, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderWins(Player player, String ladder, WeightClass weightClass);

    /**
     * Get the player's losses for a specific weight class. Main thread only.
     * @param player The player
     * @param ladder The ladder
     * @param weightClass The weight class
     * @return The player's losses, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderLosses(Player player, String ladder, WeightClass weightClass);

    /**
     * Get the player's global wins. Main thread only.
     * @param player The player
     * @return The player's global wins (unranked + ranked), or -1 if the player has no loaded profile
     */
    public abstract int getGlobalWins(Player player);

    /**
     * Retrieves the nametag information of a given player. Main thread only.
     *
     * @param player The player whose nametag information is to be retrieved.
     * @return The {@link PlayerNametag} associated with the specified player, containing
     *         prefix, name color, and suffix components, or null if the player has no loaded profile.
     */
    public abstract PlayerNametag getPlayerNametag(Player player);

    /**
     * Get the player's current state. Main thread only.
     * @param player The player
     * @return The player's state, never null; {@link PlayerState#UNKNOWN} if the player has no loaded profile
     */
    public abstract PlayerState getPlayerState(Player player);

    /**
     * Get the live match the player fights in. Spectated matches are not returned. Main thread only.
     * @param player The player
     * @return The match, or null if the player is not fighting in a match
     */
    public abstract Match getMatch(Player player);

    /**
     * Get the match the player is spectating. Main thread only.
     * @param player The player
     * @return The spectated match, or null if the player is not spectating a match
     */
    public abstract Match getSpectatingMatch(Player player);

    /**
     * Get the FFA the player fights in. Main thread only.
     * @param player The player
     * @return The FFA, or null if the player is not fighting in an FFA
     */
    public abstract FFA getFfa(Player player);

    /**
     * Get the event the player is in. Main thread only.
     * @param player The player
     * @return The event, or null if the player is not in an event
     */
    public abstract dev.nandi0813.api.Interface.Event getEvent(Player player);

    /**
     * Get the party the player is in. Main thread only.
     * @param player The player
     * @return The party, or null if the player is not in a party
     */
    public abstract Party getParty(Player player);

    /**
     * Get the queue the player is in. Main thread only.
     * @param player The player
     * @return The queue, or null if the player is not queued
     */
    public abstract Queue getQueue(Player player);

    /**
     * Get the names of all enabled ladders. Main thread only.
     * @return An unmodifiable list of ladder names, never null
     */
    public abstract List<String> getLadderNames();

    /**
     * Get the player's kills on a specific ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @return The player's kills, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderKills(Player player, String ladder);

    /**
     * Get the player's deaths on a specific ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @return The player's deaths, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderDeaths(Player player, String ladder);

    /**
     * Get the registry for addon cosmetics categories.
     * @return The cosmetics registry, never null
     */
    public abstract CosmeticsRegistry getCosmeticsRegistry();

    /**
     * Get the registry for addon hotbar items.
     * @return The hotbar item registry, never null
     */
    public abstract HotbarItemRegistry getHotbarItemRegistry();

    /**
     * Open the cosmetics hub for the player. Does nothing if the player has no loaded profile.
     * Main thread only.
     * @param player The player
     */
    public abstract void openCosmeticsMenu(Player player);

}
