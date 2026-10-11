package dev.nandi0813.api.Event;

import dev.nandi0813.api.Interface.Match;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired on the main thread after a player's elo on a ladder changed. Not cancellable.
 */
@Getter
public class EloChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /** The player, never null. */
    private final Player player;
    /** The ladder name, never null. */
    private final String ladderName;
    /** The elo before the change. */
    private final int oldElo;
    /** The elo after the change. */
    private final int newElo;
    /** The ranked match that caused the change, or null for admin changes. */
    private final Match match;

    /**
     * Create a new elo change event.
     * @param player The player
     * @param ladderName The ladder name
     * @param oldElo The elo before the change
     * @param newElo The elo after the change
     * @param match The match that caused the change, or null for admin changes
     */
    public EloChangeEvent(Player player, String ladderName, int oldElo, int newElo, Match match) {
        this.player = player;
        this.ladderName = ladderName;
        this.oldElo = oldElo;
        this.newElo = newElo;
        this.match = match;
    }

    /**
     * Get the elo change.
     * @return {@code newElo - oldElo}; negative on a loss
     */
    public int getDelta() {
        return newElo - oldElo;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get the handler list of this event.
     * @return The handler list
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
