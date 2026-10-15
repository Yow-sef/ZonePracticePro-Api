package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;

/**
 * Read-only state of a live bot practice round, passed to {@link BotOpponent#tick(BotFightView)}.
 * Only valid during that call; do not keep a reference.
 */
public interface BotFightView {

    /**
     * @return The human player the bot fights, never null
     */
    Player getOpponent();

    /**
     * @return The match id, see {@link Match#getMatchId()}
     */
    String getMatchId();

    /**
     * @return The current round number, starting at 1
     */
    int getRoundNumber();

    /**
     * @return Ticks since this round became live, starting at 0
     */
    int getRoundTicks();

    /**
     * @return A copy of the arena bounds
     */
    BoundingBox getArenaBounds();

    /**
     * @return Fighters at or below this block Y die
     */
    int getDeadZoneY();

    /**
     * @return The ladder name, never null
     */
    String getLadderName();

}
