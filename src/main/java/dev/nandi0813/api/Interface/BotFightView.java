package dev.nandi0813.api.Interface;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;

/**
 * Read-only state of a bot practice round as one bot sees it, passed to {@link BotOpponent#tick(BotFightView)}.
 * Each bot receives its own view. Only valid during that call; do not keep a reference.
 */
public interface BotFightView {

    /**
     * @return The team of the bot this view belongs to: 0 is the human team, 1 the bot team
     */
    int getTeam();

    /**
     * @return Living enemy fighters of this round, humans and bots, in a stable order. A new unmodifiable list; empty when none
     */
    List<Player> getEnemies();

    /**
     * @return Living teammates of this round, humans and bots, excluding the bot itself. A new unmodifiable list; empty when none
     */
    List<Player> getAllies();

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
