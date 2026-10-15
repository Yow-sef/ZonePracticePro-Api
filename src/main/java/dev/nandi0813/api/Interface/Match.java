package dev.nandi0813.api.Interface;

import dev.nandi0813.api.Enum.MatchType;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface Match extends Spectatable {

    /**
     * Get the players of the match.
     * @return The players of the match
     */
    List<Player> getPlayers();

    /**
     * Get the spectators of the match.
     * @return The spectators of the match
     */
    List<Player> getSpectators();

    /**
     * Get the amount of wins needed to win the match.
     * @return The amount of wins needed to win the match
     */
    int getWinsNeeded();

    /**
     * Get the ladder name of the match.
     * @return The ladder name of the match, or null if not set
     */
    String getLadderName();

    /**
     * Get the ladder display name of the match.
     * @return The ladder display name of the match, or null if not set
     */
    String getLadderDisplayName();

    /**
     * Get the unique id of the match.
     * @return The match id, never null
     * @since 2.4.0
     */
    default String getMatchId() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Get the name of the arena the match is played in.
     * @return The arena name, never null
     * @since 2.4.0
     */
    default String getArenaName() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Check whether the match is ranked.
     * @return true if the match is ranked
     * @since 2.4.0
     */
    default boolean isRanked() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Get the type of the match.
     * @return The match type, never null; {@link MatchType#UNKNOWN} for types added by a newer core version
     * @since 2.4.0
     */
    default MatchType getMatchType() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Get how long the match has been running.
     * @return The duration in seconds
     * @since 2.4.0
     */
    default int getDurationSeconds() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Get the current round number.
     * @return The current round number, 1-based
     * @since 2.4.0
     */
    default int getCurrentRoundNumber() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

    /**
     * Get the inventory snapshots of every player in every finished round. Main thread only.
     * Snapshots of a round are available from MatchRoundEndEvent of that round, and all of them from MatchEndEvent.
     * @return An unmodifiable list sorted by round number, never null. Players offline at round end are missing.
     * @since 2.6.0
     */
    default List<RoundInventory> getRoundInventories() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.6.0+");
    }

    /**
     * Get the inventory snapshots of one player in every finished round. Main thread only.
     * @param player The player's unique id
     * @return An unmodifiable list sorted by round number, never null
     * @since 2.6.0
     */
    default List<RoundInventory> getRoundInventories(UUID player) {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.6.0+");
    }

    /**
     * Get the inventory snapshot of one player in one round. Main thread only.
     * @param player The player's unique id
     * @param round The round number, 1-based
     * @return The snapshot, or null if none was saved for that player and round
     * @since 2.6.0
     */
    default RoundInventory getRoundInventory(UUID player, int round) {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.6.0+");
    }

}
