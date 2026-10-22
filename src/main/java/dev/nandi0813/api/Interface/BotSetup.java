package dev.nandi0813.api.Interface;

import java.util.Objects;

/**
 * A bot practice setup that can be started again, for example from a rematch button.
 *
 * @param ladderName The ladder name, never null
 * @param arenaName The arena name, or null for an automatically chosen arena
 * @param winsNeeded Rounds needed to win the match, 1-10
 * @param options The bot options, never null
 * @param teamSize Fighters per team, 1-4. The human team is the player (or their party) plus bots; the bot team has this many bots
 */
public record BotSetup(String ladderName, String arenaName, int winsNeeded, BotOptions options, int teamSize) {

    public static final int MAX_TEAM_SIZE = 4;

    public BotSetup {
        Objects.requireNonNull(ladderName, "ladderName");
        Objects.requireNonNull(options, "options");
        if (winsNeeded < 1 || winsNeeded > 10) {
            throw new IllegalArgumentException("winsNeeded must be between 1 and 10");
        }
        if (teamSize < 1 || teamSize > MAX_TEAM_SIZE) throw new IllegalArgumentException("teamSize must be between 1 and " + MAX_TEAM_SIZE);
    }

    public BotSetup(String ladderName, String arenaName, int winsNeeded, BotOptions options) {
        this(ladderName, arenaName, winsNeeded, options, 1);
    }

}
