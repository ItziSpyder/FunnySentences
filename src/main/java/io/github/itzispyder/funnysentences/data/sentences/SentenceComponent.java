package io.github.itzispyder.funnysentences.data.sentences;

import java.util.List;

/**
 * Basic sentence components
 */
public enum SentenceComponent {

    NOUN,
    VERB,
    SUBJECT,
    ADJECTIVE,
    PREPOSITION,
    CONJUNCTION,
    PLACE;

    /**
     * Returns the defaults of this component
     * @return default
     */
    public List<String> getDefaults() {
        return DefaultSentenceComponents.defaultFromComponent(this);
    }
}
