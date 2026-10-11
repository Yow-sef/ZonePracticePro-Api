package dev.nandi0813.api.Event;

import dev.nandi0813.api.Enum.PlayerState;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * Fired on the main thread when a player's {@link PlayerState} changes. Fired only when {@code from != to}.
 * Not cancellable.
 */
@Getter
public class PlayerStateChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /** The id of the player, never null. */
    private final UUID playerId;
    /** The player, or null when the player is offline (for example {@code to == OFFLINE} on quit). */
    private final Player player;
    /** The previous state, never null. */
    private final PlayerState from;
    /** The new state, never null. */
    private final PlayerState to;

    /**
     * Create a new player state change event.
     * @param playerId The id of the player
     * @param player The player, or null when the player is offline
     * @param from The previous state
     * @param to The new state
     */
    public PlayerStateChangeEvent(UUID playerId, Player player, PlayerState from, PlayerState to) {
        this.playerId = playerId;
        this.player = player;
        this.from = from;
        this.to = to;
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
