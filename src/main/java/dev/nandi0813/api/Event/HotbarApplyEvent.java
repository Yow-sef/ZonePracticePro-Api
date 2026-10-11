package dev.nandi0813.api.Event;

import dev.nandi0813.api.Enum.HotbarLayout;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired after the core applied a hotbar layout and its registered addon items.
 * Fired on the main thread. Not cancellable.
 */
@Getter
public class HotbarApplyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /** The player, never null. */
    private final Player player;
    /** The applied layout, never null. */
    private final HotbarLayout layout;

    /**
     * Create a new hotbar apply event.
     * @param player The player
     * @param layout The applied layout
     */
    public HotbarApplyEvent(Player player, HotbarLayout layout) {
        this.player = player;
        this.layout = layout;
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
