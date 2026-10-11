package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;

public interface Queue {

    /**
     * Get the player
     * @return the player
     */
    Player getPlayer();

    /**
     * Get the duration
     * @return the duration
     */
    int getDuration();

    /**
     * Get the type
     * @return the type
     */
    boolean isRanked();

    /**
     * Get the name of the ladder the player is queued for.
     * @return The ladder name, never null
     * @since 2.4.0
     */
    default String getLadderName() {
        throw new UnsupportedOperationException("Requires ZonePractice Pro with API 2.4.0+");
    }

}
