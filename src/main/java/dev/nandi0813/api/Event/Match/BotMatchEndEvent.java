package dev.nandi0813.api.Event.Match;

import dev.nandi0813.api.Interface.Match;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired once when a bot practice match that reached the live phase ends.
 * Round counts are from the human team's view (team 0).
 */
@Getter
public class BotMatchEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Match match;
    private final Outcome outcome;
    private final int humanRounds;
    private final int botRounds;
    private final int drawRounds;

    public BotMatchEndEvent(Match match, Outcome outcome, int humanRounds, int botRounds, int drawRounds) {
        this.match = match;
        this.outcome = outcome;
        this.humanRounds = humanRounds;
        this.botRounds = botRounds;
        this.drawRounds = drawRounds;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum Outcome {
        HUMAN_WIN,
        BOT_WIN,
        DRAW,
        ABORTED
    }

}
