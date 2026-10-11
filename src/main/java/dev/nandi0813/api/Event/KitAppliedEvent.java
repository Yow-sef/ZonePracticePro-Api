package dev.nandi0813.api.Event;

import dev.nandi0813.api.Enum.FightType;
import dev.nandi0813.api.Interface.Spectatable;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired after the kit and kit cosmetics are in the player's inventory. Listeners may modify the inventory.
 * Fired on the main thread. Not cancellable.
 */
@Getter
public class KitAppliedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /** The player, never null. */
    private final Player player;
    /** The type of the fight, never null. */
    private final FightType fightType;
    /** The fight, never null. */
    private final Spectatable fight;
    /** The ladder name, never null. */
    private final String ladderName;

    /**
     * Create a new kit applied event.
     * @param player The player
     * @param fightType The type of the fight
     * @param fight The fight
     * @param ladderName The ladder name
     */
    public KitAppliedEvent(Player player, FightType fightType, Spectatable fight, String ladderName) {
        this.player = player;
        this.fightType = fightType;
        this.fight = fight;
        this.ladderName = ladderName;
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
