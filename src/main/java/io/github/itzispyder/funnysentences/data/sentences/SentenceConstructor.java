package io.github.itzispyder.funnysentences.data.sentences;

import io.github.itzispyder.funnysentences.data.Config;
import io.github.itzispyder.funnysentences.util.ArgBuilder;
import io.github.itzispyder.funnysentences.util.Randomizer;
import org.apache.commons.lang3.StringUtils;

/**
 * Constructs sentences
 */
public abstract class SentenceConstructor {

    /**
     * Generates a sentence with a sentence generator and a sentence feature
     * Sentence features will be IGNORED for NORMAL sentence generator
     * @param type generator
     * @param feature feature
     * @return generated sentence
     */
    public static String generate(SentenceGenerator type, SentenceFeature feature) {
        if (type == SentenceGenerator.NORMAL) return normal();
        return custom(type,feature);
    }

    /**
     * Generates custom sentence with features
     * @param type generator
     * @param feature feature
     * @return generated sentence
     */
    private static String custom(SentenceGenerator type, SentenceFeature feature) {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < feature.getWordCount(); i ++) {
            int wordLength = Randomizer.rand(feature.getMinWordLength(), feature.getMaxWordLength());
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < wordLength; j++) {
                switch (type) {
                    case RAGE -> word.append(new Randomizer<>(DefaultSentenceComponents.ALPHABET).pickRand());
                    case EMOJI -> word.append(new Randomizer<>(DefaultSentenceComponents.EMOJIS).pickRand());
                    case UNICODE -> word.append(new Randomizer<>(DefaultSentenceComponents.UNICODES).pickRand());
                }
            }
            sentence.append(word).append(" ");
        }
        return sentence.toString().trim().concat(".");
    }

    /**
     * Generates a normal sentence
     * @return generated sentence
     */
    private static String normal() {
        String subject = new Randomizer<>(Config.subjectList).pickRand();
        String adjective = new Randomizer<>(Config.adjectiveList).pickRand();
        String noun = new Randomizer<>(Config.nounsList).pickRand();
        String verb = new Randomizer<>(Config.verbList).pickRand();
        String subject2 = new Randomizer<>(Config.subjectList).pickRand();
        String adjective2 = new Randomizer<>(Config.adjectiveList).pickRand();
        String noun2 = new Randomizer<>(Config.nounsList).pickRand();
        String preposition = new Randomizer<>(Config.prepositionList).pickRand();
        String subject3 = new Randomizer<>(Config.subjectList).pickRand();
        String adjective3 = new Randomizer<>(Config.adjectiveList).pickRand();
        String place = new Randomizer<>(Config.placeList).pickRand();
        String conjunction = new Randomizer<>(Config.conjunctionList).pickRand();
        String subject4 = new Randomizer<>(Config.subjectList).pickRand();
        String adjective4 = new Randomizer<>(Config.adjectiveList).pickRand();
        String noun3 = new Randomizer<>(Config.nounsList).pickRand();
        String verb2 = new Randomizer<>(Config.verbList).pickRand();
        return StringUtils.capitalize(new ArgBuilder()
                .append(subject)
                .append(adjective)
                .append(noun)
                .append(verb)
                .append(subject2)
                .append(adjective2)
                .append(noun2)
                .append(preposition)
                .append(subject3)
                .append(adjective3)
                .append(place)
                .append(conjunction)
                .append(subject4)
                .append(adjective4)
                .append(noun3)
                .append(verb2)
                .append(subject)
                .append(adjective)
                .append(noun)
                .build()
                .concat("."));
    }
}
