package dev.nandi0813.api.Enum;

/**
 * The state of a player in ZonePractice Pro.
 */
public enum PlayerState {

    /** The player is offline. */
    OFFLINE,
    /** The player is in the lobby. */
    LOBBY,
    /** The player is editing a ladder kit. */
    EDITOR,
    /** The player is editing a custom kit. */
    CUSTOM_EDITOR,
    /** The player is in a match queue. */
    QUEUE,
    /** The player fights in a match. */
    MATCH,
    /** The player fights in an FFA. */
    FFA,
    /** The player is in an event. */
    EVENT,
    /** The player spectates a match, FFA or event. */
    SPECTATE,
    /** The player is in staff mode. */
    STAFF_MODE,
    /** Profile not loaded, or a state added by a newer core version. */
    UNKNOWN;

    /**
     * Check whether this state is a fighting state.
     * @return true for MATCH, FFA and EVENT.
     */
    public boolean isFighting() {
        return this == MATCH || this == FFA || this == EVENT;
    }

    /**
     * Check whether this state is a lobby state.
     * @return true for LOBBY and STAFF_MODE.
     */
    public boolean isInLobby() {
        return this == LOBBY || this == STAFF_MODE;
    }

}
