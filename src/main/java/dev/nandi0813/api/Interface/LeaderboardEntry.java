package dev.nandi0813.api.Interface;

import java.util.Objects;
import java.util.UUID;

/**
 * One entry on a ZonePractice Pro leaderboard. Immutable.
 *
 * @param playerId The player's unique id, never null
 * @param playerName The player's last known name, never null
 * @param rank The 1-based rank on the board
 * @param score The value the board is sorted by
 * @since 2.9.0
 */
public record LeaderboardEntry(UUID playerId, String playerName, int rank, int score) {

    public LeaderboardEntry {
        Objects.requireNonNull(playerId, "playerId");
        Objects.requireNonNull(playerName, "playerName");
        if (rank < 1) {
            throw new IllegalArgumentException("rank must be at least 1");
        }
    }

}
