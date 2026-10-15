package dev.nandi0813.api.Interface;

import org.bukkit.entity.Player;

/**
 * A bot body spawned by a {@link BotProvider} for one round.
 * The core calls every method on the main thread.
 */
public interface BotOpponent {

    /**
     * The live body. Its UUID equals the entity id passed to {@link BotProvider#spawn}.
     * @return The body, never null
     */
    Player getPlayer();

    /**
     * Run one tick of bot behavior. Called once per server tick while the round is live, and never otherwise.
     * Throwing an exception ends the match.
     * @param view The current round state
     */
    void tick(BotFightView view);

    /**
     * Stop all inputs and item use, keeping the current momentum.
     * Called during the countdown, at round end and after a death.
     */
    void pause();

    /**
     * Show the body to a fighter or spectator.
     * @param viewer The viewer
     */
    void show(Player viewer);

    /**
     * Hide the body from a viewer. Also called for viewers who went offline.
     * @param viewer The viewer
     */
    void hide(Player viewer);

    /**
     * Remove the body. Called when the round or match ends; must be safe to call more than once.
     */
    void remove();

}
