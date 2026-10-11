package dev.nandi0813.api.Interface;

import dev.nandi0813.api.Enum.MatchType;
import org.bukkit.entity.Player;

import java.util.List;

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

}
