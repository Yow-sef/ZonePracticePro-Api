package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;

/**
 * Read-only state of a bot practice round in its start countdown or live, passed to {@link BotOpponent#tick(BotFightView)}.
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
     * @return Ticks since this round became live, starting at 0; 0 during the countdown
     */
    int getRoundTicks();

    /**
     * @return True while the round is live. False during the start countdown, when the body must not move, attack
     * or shoot, but may eat and use potions
     */
    boolean isLive();

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
