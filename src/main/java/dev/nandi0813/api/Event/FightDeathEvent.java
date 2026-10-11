package dev.nandi0813.api.Event;

import dev.nandi0813.api.Enum.FightType;
import dev.nandi0813.api.Interface.FFA;
import dev.nandi0813.api.Interface.Match;
import dev.nandi0813.api.Interface.Spectatable;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired once per confirmed death, after stats are updated and before the round/match reacts to it.
 * Not fired for event game modes in 2.4.0. Fired on the main thread. Not cancellable.
 */
@Getter
public class FightDeathEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    /** The player who died, never null. */
    private final Player victim;
    /** The killer, or null if the victim died without a killer. */
    private final Player killer;
    /** The type of the fight, never null. */
    private final FightType fightType;
    /** The fight ({@link Match} or {@link FFA}), never null. */
    private final Spectatable fight;
    /** The ladder name, never null. */
    private final String ladderName;
    /** The death message in MiniMessage format, or null if none is sent. */
    private final String deathMessage;

    /**
     * Create a new fight death event.
     * @param victim The player who died
     * @param killer The killer, nullable
     * @param fightType The type of the fight
     * @param fight The fight
     * @param ladderName The ladder name
     * @param deathMessage The death message in MiniMessage format, nullable
     */
    public FightDeathEvent(Player victim, Player killer, FightType fightType, Spectatable fight, String ladderName, String deathMessage) {
        this.victim = victim;
        this.killer = killer;
        this.fightType = fightType;
        this.fight = fight;
        this.ladderName = ladderName;
        this.deathMessage = deathMessage;
    }

    /**
     * Check whether the victim was killed by a player.
     * @return true if the victim was killed by a player
     */
    public boolean hasKiller() {
        return killer != null;
    }

    /**
     * Get the fight as a match.
     * @return The fight as a {@link Match}, or null if the fight is not a match
     */
    public Match getMatch() {
        return fight instanceof Match ? (Match) fight : null;
    }

    /**
     * Get the fight as an FFA.
     * @return The fight as an {@link FFA}, or null if the fight is not an FFA
     */
    public FFA getFfa() {
        return fight instanceof FFA ? (FFA) fight : null;
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
