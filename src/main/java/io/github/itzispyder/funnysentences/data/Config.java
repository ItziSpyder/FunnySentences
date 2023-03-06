package io.github.itzispyder.funnysentences.data;

import io.github.itzispyder.funnysentences.data.sentences.SentenceComponent;
import io.github.itzispyder.funnysentences.registry.ConfigurationRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for the mod (MAINLY FOR THE WORDS LIST)
 */
public abstract class Config {

    public static void reload() {
        ConfigurationRegistry.registerAll();
    }

    public static List<String> subjectList = new ArrayList<>();
    public static List<String> nounsList = new ArrayList<>();
    public static List<String> verbList = new ArrayList<>();
    public static List<String> prepositionList = new ArrayList<>();
    public static List<String> conjunctionList = new ArrayList<>();
    public static List<String> placeList = new ArrayList<>();
    public static List<String> adjectiveList = new ArrayList<>();

    /**
     * Updates the config data for sentence components
     * @param component component to update
     * @param newList new component
     */
    public static void updateSentenceComponent(SentenceComponent component, List<String> newList) {
        switch (component) {
            case NOUN -> nounsList = newList;
            case VERB -> verbList = newList;
            case SUBJECT -> subjectList = newList;
            case PLACE -> placeList = newList;
            case CONJUNCTION -> conjunctionList = newList;
            case ADJECTIVE -> adjectiveList = newList;
            case PREPOSITION -> prepositionList = newList;
        }
    }
}
