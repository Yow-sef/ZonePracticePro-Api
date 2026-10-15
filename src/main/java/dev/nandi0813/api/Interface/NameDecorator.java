package dev.nandi0813.api.Interface;

import dev.nandi0813.api.Enum.NameLocation;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

/**
 * Adds components before or after a player's name wherever ZonePractice Pro renders it.
 * {@link NameLocation#CHAT} is requested from the async chat thread, so implementations must be thread-safe
 * and must not call the Bukkit API for that location.
 */
public interface NameDecorator {

    /**
     * Unique id, lowercase [a-z0-9_-], e.g. "myaddon_nametags".
     * @return The id, never null
     */
    String getId();

    /**
     * Component placed before the player's prefix. Nullable.
     * @param player The player whose name is rendered
     * @param location Where the name is rendered
     * @return The component, or null for none
     */
    Component getPrefix(Player player, NameLocation location);

    /**
     * Component placed after the player's suffix. Nullable.
     * @param player The player whose name is rendered
     * @param location Where the name is rendered
     * @return The component, or null for none
     */
    Component getSuffix(Player player, NameLocation location);

    /**
     * Lower values are rendered closer to the name.
     * @return The priority, 0 by default
     */
    default int getPriority() {
        return 0;
    }

}
