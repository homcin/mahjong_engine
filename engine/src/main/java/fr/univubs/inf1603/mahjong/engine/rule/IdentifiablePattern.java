package fr.univubs.inf1603.mahjong.engine.rule;

import fr.univubs.inf1603.mahjong.engine.rule.PlayerSet;
import java.util.Collection;

/**
 * Interface representing a pattern.
 * A pattern is a group of {@link GameTile} and/or {@link Combination}.
 */
public interface IdentifiablePattern {
    /**
     * @return the point value the pattern is worth
     */
    int getValue();

    /**
     * Find all the occurrences of the pattern in a {@link PlayerSet}, placing them in
     * {@link IdentifiedPattern IdentifiedPatterns}
     * @param set set to analyse
     * @return all occurrences of the pattern in new identified patterns
     */
    Collection<IdentifiedPattern> identify(PlayerSet set);
}
