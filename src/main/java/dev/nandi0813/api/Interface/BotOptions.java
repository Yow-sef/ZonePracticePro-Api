package dev.nandi0813.api.Interface;

import java.util.Map;
import java.util.Objects;

/**
 * Settings chosen for a bot opponent, for example its difficulty. Immutable.
 * The core does not interpret {@link #values()}; it passes them back to the {@link BotProvider}.
 *
 * @param label Plain display name shown to players, for example "Normal". 1-32 characters, no MiniMessage tags.
 * @param values Provider-defined settings, for example {@code difficulty=3}. Copied, never null.
 */
public record BotOptions(String label, Map<String, String> values) {

    public BotOptions {
        Objects.requireNonNull(label, "label");
        Objects.requireNonNull(values, "values");
        if (label.isBlank() || label.length() > 32 || label.indexOf('<') >= 0 || label.indexOf('>') >= 0) {
            throw new IllegalArgumentException("Bot option label must be 1-32 characters of plain text");
        }
        values = Map.copyOf(values);
    }

}
