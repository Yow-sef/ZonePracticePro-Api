package dev.nandi0813.api.Enum;

/**
 * The type of a match.
 */
public enum MatchType {

    /** A 1v1 duel. */
    DUEL,
    /** A free-for-all between the members of one party. */
    PARTY_FFA,
    /** One party split into two teams. */
    PARTY_SPLIT,
    /** Two parties fighting each other. */
    PARTY_VS_PARTY,
    /** A practice match of one player against a bot opponent. Requires a bot addon. (2.7.0+) */
    BOT,
    /** A match type added by a newer core version. */
    UNKNOWN

}
