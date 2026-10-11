package dev.nandi0813.api.Event;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired once when ZonePractice Pro finished loading ladders, arenas, leaderboards and holograms.
 * Register cosmetics categories and hotbar items in onEnable; use this event for logic that needs loaded ladders.
 * Fired on the main thread. Not cancellable.
 */
@Getter
public class ZonePracticeReadyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /**
     * Create a new ready event.
     */
    public ZonePracticeReadyEvent() {
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
