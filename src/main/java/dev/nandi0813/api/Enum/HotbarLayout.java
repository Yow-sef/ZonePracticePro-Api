package dev.nandi0813.api.Enum;

/**
 * The hotbar layouts the core rebuilds; addon items are re-applied on every rebuild.
 */
public enum HotbarLayout {

    /** The lobby hotbar. */
    LOBBY,
    /** The hotbar of a player in a party. */
    PARTY,
    /** The hotbar of a player in a match queue. */
    MATCH_QUEUE,
    /** The hotbar of a player in an event queue. */
    EVENT_QUEUE,
    /** The staff mode hotbar. */
    STAFF_MODE,
    /** The hotbar of a spectator in the lobby. */
    SPECTATOR_LOBBY,
    /** The hotbar of a match spectator. */
    SPECTATE_MATCH,
    /** The hotbar of an event spectator. */
    SPECTATE_EVENT,
    /** The hotbar of an FFA spectator. */
    SPECTATE_FFA

}
