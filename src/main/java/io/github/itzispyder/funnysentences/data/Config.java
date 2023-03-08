package io.github.itzispyder.funnysentences.data;

import io.github.itzispyder.funnysentences.data.sentences.SentenceComponent;
import io.github.itzispyder.funnysentences.registry.ConfigurationRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Configuration for the mod (MAINLY FOR THE WORDS LIST)
 */
public abstract class Config {

    public static void reload() {
        ConfigurationRegistry.registerAll();
    }

    public static List<String> subjectList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> nounsList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> verbList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> prepositionList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> conjunctionList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> placeList = Collections.unmodifiableList(new ArrayList<>());
    public static List<String> adjectiveList = Collections.unmodifiableList(new ArrayList<>());

    /**
     * Updates the config data for sentence components
     * @param component component to update
     * @param newList new component
     */
    public static void updateSentenceComponent(SentenceComponent component, List<String> newList) {
        List<String> unmodifiableList = Collections.unmodifiableList(newList);
        switch (component) {
            case NOUN -> nounsList = unmodifiableList;
            case VERB -> verbList = unmodifiableList;
            case SUBJECT -> subjectList = unmodifiableList;
            case PLACE -> placeList = unmodifiableList;
            case CONJUNCTION -> conjunctionList = unmodifiableList;
            case ADJECTIVE -> adjectiveList = unmodifiableList;
            case PREPOSITION -> prepositionList = unmodifiableList;
        }
    }
}
