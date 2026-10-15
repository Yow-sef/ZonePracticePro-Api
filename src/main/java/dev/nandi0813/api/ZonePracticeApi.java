package dev.nandi0813.api;

import dev.nandi0813.api.Enum.DivisionName;
import dev.nandi0813.api.Enum.LeaderboardType;
import dev.nandi0813.api.Enum.PlayerState;
import dev.nandi0813.api.Enum.WeightClass;
import dev.nandi0813.api.Interface.BotRegistry;
import dev.nandi0813.api.Interface.CosmeticsRegistry;
import dev.nandi0813.api.Interface.FFA;
import dev.nandi0813.api.Interface.HotbarItemRegistry;
import dev.nandi0813.api.Interface.Match;
import dev.nandi0813.api.Interface.NameDecorationRegistry;
import dev.nandi0813.api.Interface.Party;
import dev.nandi0813.api.Interface.Queue;
import dev.nandi0813.api.Utilities.PlayerNametag;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class ZonePracticeApi
{

    /**
     * Incremented on every additive API release. 2.4.0 = 3, 2.5.0 = 4, 2.6.0 = 5, 2.7.0 = 6, 2.8.0 = 7.
     */
    public static final int API_VERSION = 7;

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
     * Get a match by its id, including matches that already ended. Main thread only.
     * @param matchId The match id, see {@link Match#getMatchId()}
     * @return The match, or null if no match has this id
     * @since 2.6.0
     */
    public abstract Match getMatchById(String matchId);

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

    /**
     * Get the registry for name decorators.
     * @return The name decoration registry, never null
     */
    public abstract NameDecorationRegistry getNameDecorationRegistry();

    /**
     * Get the player's current global win streak. Main thread only.
     * @param player The player
     * @return The win streak, or -1 if the player has no loaded profile
     */
    public abstract int getWinStreak(Player player);

    /**
     * Get the player's best global win streak. Main thread only.
     * @param player The player
     * @return The best win streak, or -1 if the player has no loaded profile
     */
    public abstract int getBestWinStreak(Player player);

    /**
     * Get the player's best win streak on a specific ladder and weight class. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @param weightClass The weight class
     * @return The best win streak, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderBestWinStreak(Player player, String ladder, WeightClass weightClass);

    /**
     * Get the player's current FFA kill streak. Main thread only.
     * @param player The player
     * @return The kill streak, or -1 if the player has no loaded profile
     */
    public abstract int getKillStreak(Player player);

    /**
     * Get the player's best global FFA kill streak. Main thread only.
     * @param player The player
     * @return The best kill streak, or -1 if the player has no loaded profile
     */
    public abstract int getBestKillStreak(Player player);

    /**
     * Get the player's best FFA kill streak on a specific ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @return The best kill streak, or -1 if the player has no loaded profile or the ladder name is unknown
     */
    public abstract int getLadderBestKillStreak(Player player, String ladder);

    /**
     * Get the player's kills summed over all ladders. Main thread only.
     * @param player The player
     * @return The global kills, or -1 if the player has no loaded profile
     */
    public abstract int getGlobalKills(Player player);

    /**
     * Get the player's global matches played (wins + losses). Main thread only.
     * @param player The player
     * @return The matches played, or -1 if the player has no loaded profile
     */
    public abstract int getMatchesPlayed(Player player);

    /**
     * Get the time the player first joined the server. Main thread only.
     * @param player The player
     * @return The first join time in epoch millis, or -1 if the player has no loaded profile
     */
    public abstract long getFirstJoin(Player player);

    /**
     * Get the names of all divisions, ordered lowest to highest. Main thread only.
     * @param divisionName Short or Full name of the divisions
     * @return An unmodifiable list of division names, never null
     */
    public abstract List<String> getDivisionNames(DivisionName divisionName);

    /**
     * Get the player's position on a leaderboard. Main thread only.
     * @param player The player
     * @param type The statistic the leaderboard is ranked by
     * @param ladder The ladder name, or null for the global leaderboard.
     * @return The 1-based position, or -1 if the player is not on the leaderboard, the leaderboard does not exist,
     *         or the ladder name is unknown. Leaderboards hold the top entries only and refresh periodically.
     */
    public abstract int getLeaderboardPosition(Player player, LeaderboardType type, String ladder);

    /**
     * Queue the player for a ladder, like the queue menu does. The player gets the usual queue messages.
     * Already queued for the ladder: nothing changes. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @param ranked true for the ranked queue, false for unranked
     * @param keepInventoryOpen Keep the player's open inventory open, only applies with multi-queue
     * @return true if the player is queued for the ladder or a match started right away; false if the player has
     *         no loaded profile, is not in the lobby or a queue, is in staff mode or a party, the ladder is unknown,
     *         disabled, frozen or unranked-only for a ranked queue, or a queue requirement failed
     * @since 2.7.0
     */
    public abstract boolean queuePlayer(Player player, String ladder, boolean ranked, boolean keepInventoryOpen);

    /**
     * Remove a ladder from the player's queue. The queue ends when it was the last ladder.
     * Does nothing if the player is not queued for the ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @since 2.7.0
     */
    public abstract void leaveQueue(Player player, String ladder);

    /**
     * End the player's queue for every ladder. Does nothing if the player is not queued. Main thread only.
     * @param player The player
     * @since 2.7.0
     */
    public abstract void leaveAllQueues(Player player);

    /**
     * Check whether the player may queue for several ladders at once. Main thread only.
     * @param player The player
     * @return true if multi-queue is enabled in the config and the player has its permission
     * @since 2.7.0
     */
    public abstract boolean isMultiQueueAllowed(Player player);

    /**
     * Get the names of the ladders the player is queued for. Main thread only.
     * @param player The player
     * @return An unmodifiable list of ladder names, empty if the player is not queued, never null
     * @since 2.7.0
     */
    public abstract List<String> getQueuedLadderNames(Player player);

    /**
     * Check whether the player is queued for a ladder. Main thread only.
     * @param player The player
     * @param ladder The ladder name
     * @return true if the player is queued for the ladder
     * @since 2.7.0
     */
    public abstract boolean isQueued(Player player, String ladder);

    /**
     * Get the number of players queued for a ladder in one queue type. Main thread only.
     * @param ladder The ladder name
     * @param ranked true for the ranked queue, false for unranked
     * @return The number of queued players, or -1 if the ladder name is unknown
     * @since 2.7.0
     */
    public abstract int getQueuePlayerCount(String ladder, boolean ranked);

    /**
     * Get the number of players queued for a ladder, ranked and unranked together. Main thread only.
     * @param ladder The ladder name
     * @return The number of queued players, or -1 if the ladder name is unknown
     * @since 2.7.0
     */
    public abstract int getQueuePlayerCount(String ladder);

    /**
     * Get the icon of a ladder. Main thread only.
     * @param ladder The ladder name
     * @return A copy of the ladder icon, or null if the ladder name is unknown or the ladder has no icon
     * @since 2.7.0
     */
    public abstract ItemStack getLadderIcon(String ladder);

    /**
     * Get the display name of a ladder. Main thread only.
     * @param ladder The ladder name
     * @return The display name in MiniMessage format, or null if the ladder name is unknown
     * @since 2.7.0
     */
    public abstract String getLadderDisplayName(String ladder);

    /**
     * Get the player's progress towards the next division, the same value the division menu shows. Main thread only.
     * @param player The player
     * @return The progress from 0 to 100, 100 if the player is in the highest division, or -1 if the player has no
     *         loaded profile or no divisions exist
     * @since 2.7.0
     */
    public abstract double getPlayerDivisionProgress(Player player);

    /**
     * Get the division after the player's current division. Main thread only.
     * @param player The player
     * @param divisionName Short or Full name of the division
     * @return The next division's name, or null if the player has no loaded profile or is in the highest division
     * @since 2.7.0
     */
    public abstract String getPlayerNextDivision(Player player, DivisionName divisionName);

    /**
     * Get the global elo a division requires. Main thread only.
     * @param division The division's key in divisions.yml, or its short or full name as returned by
     *                 {@link #getDivisionNames(DivisionName)}
     * @return The required elo, or -1 if the division is unknown
     * @since 2.7.0
     */
    public abstract int getDivisionRequiredElo(String division);

    /**
     * Get the global experience a division requires. Main thread only.
     * @param division The division's key in divisions.yml, or its short or full name as returned by
     *                 {@link #getDivisionNames(DivisionName)}
     * @return The required experience, or -1 if the division is unknown
     * @since 2.7.0
     */
    public abstract int getDivisionRequiredExperience(String division);

    /**
     * Get the global wins a division requires. Main thread only.
     * @param division The division's key in divisions.yml, or its short or full name as returned by
     *                 {@link #getDivisionNames(DivisionName)}
     * @return The required wins, or -1 if the division is unknown
     * @since 2.7.0
     */
    public abstract int getDivisionRequiredWins(String division);

    /**
     * Get the registry that connects a bot addon to ZonePractice Pro.
     * @return The bot registry, never null
     * @since 2.8.0
     */
    public abstract BotRegistry getBotRegistry();

}
