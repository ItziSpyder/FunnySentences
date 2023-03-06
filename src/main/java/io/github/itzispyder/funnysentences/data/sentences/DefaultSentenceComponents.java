package io.github.itzispyder.funnysentences.data.sentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defaulted sentence components, will be used if the sentence configurations
 * are found to be empty.
 */
public abstract class DefaultSentenceComponents {

    public static final List<String> NOUNS = Arrays.asList(
            "dog",
            "cat",
            "table",
            "mouse",
            "table",
            "carpet",
            "pencil",
            "eraser",
            "dress",
            "socks",
            "apple",
            "notebook",
            "backpack",
            "mug",
            "keyboard",
            "glasses",
            "lunch",
            "breakfast",
            "snack",
            "box",
            "ball",
            "bucket",
            "mailman",
            "mom",
            "sister",
            "dad",
            "computer",
            "pickle",
            "banana"
    );

    public static final List<String> SUBJECTS = Arrays.asList(
            "my",
            "its",
            "her",
            "his",
            "their",
            "our",
            "a",
            "the"
    );

    public static final List<String> ADJECTIVES = Arrays.asList(
            "messy",
            "tidy",
            "stinky",
            "shiny",
            "ugly",
            "hot",
            "beautiful",
            "cold",
            "wet",
            "slippery",
            "nasty",
            "old",
            "new",
            "young"
    );

    public static final List<String> VERBS = Arrays.asList(
            "kicked",
            "licked",
            "tasted",
            "swallowed",
            "chugged",
            "drank",
            "touched",
            "felt",
            "saw",
            "stroked",
            "liked",
            "stabbed",
            "jumped",
            "leaped",
            "knocked",
            "picked",
            "ate"
    );

    public static final List<String> PREPOSITIONS = Arrays.asList(
            "out",
            "in",
            "inside",
            "outside",
            "over",
            "under",
            "below",
            "between",
            "beside",
            "near",
            "next to"
    );

    public static final List<String> PLACES = Arrays.asList(
            "school",
            "house",
            "bathroom",
            "post office",
            "cafeteria",
            "hotel",
            "bedrock",
            "grocery store"
    );

    public static final List<String> CONJUNCTIONS = Arrays.asList(
            "because",
            "but",
            "and",
            "but what's even crazier is",
            "and to make things more interesting",
            "however"
    );

    /**
     * Returns a default list based on the given sentence component
     * @param component component
     * @return default component value
     */
    public static final List<String> defaultFromComponent(SentenceComponent component) {
        switch (component) {
            case NOUN: return NOUNS;
            case VERB: return VERBS;
            case ADJECTIVE: return ADJECTIVES;
            case PLACE: return PLACES;
            case PREPOSITION: return PREPOSITIONS;
            case CONJUNCTION: return CONJUNCTIONS;
            case SUBJECT: return SUBJECTS;
            default: new ArrayList<>();
        }
        return new ArrayList<>();
    }
}
