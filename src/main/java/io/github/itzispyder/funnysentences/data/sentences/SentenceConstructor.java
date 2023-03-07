package io.github.itzispyder.funnysentences.data.sentences;

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
        String result = "";
        if (type == SentenceGenerator.NORMAL) {
            String subject = new Randomizer<>(DefaultSentenceComponents.SUBJECTS).pickRand();
            String adjective = new Randomizer<>(DefaultSentenceComponents.ADJECTIVES).pickRand();
            String noun = new Randomizer<>(DefaultSentenceComponents.NOUNS).pickRand();
            String verb = new Randomizer<>(DefaultSentenceComponents.VERBS).pickRand();
            String subject2 = new Randomizer<>(DefaultSentenceComponents.SUBJECTS).pickRand();
            String adjective2 = new Randomizer<>(DefaultSentenceComponents.ADJECTIVES).pickRand();
            String noun2 = new Randomizer<>(DefaultSentenceComponents.NOUNS).pickRand();
            String preposition = new Randomizer<>(DefaultSentenceComponents.PREPOSITIONS).pickRand();
            String subject3 = new Randomizer<>(DefaultSentenceComponents.SUBJECTS).pickRand();
            String adjective3 = new Randomizer<>(DefaultSentenceComponents.ADJECTIVES).pickRand();
            String place = new Randomizer<>(DefaultSentenceComponents.PLACES).pickRand();
            String conjunction = new Randomizer<>(DefaultSentenceComponents.CONJUNCTIONS).pickRand();
            String subject4 = new Randomizer<>(DefaultSentenceComponents.SUBJECTS).pickRand();
            String adjective4 = new Randomizer<>(DefaultSentenceComponents.ADJECTIVES).pickRand();
            String noun3 = new Randomizer<>(DefaultSentenceComponents.NOUNS).pickRand();
            String verb2 = new Randomizer<>(DefaultSentenceComponents.VERBS).pickRand();
            result = StringUtils.capitalize(new ArgBuilder()
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
                    .trim()
                    .concat("."));
        }
        else {
            StringBuilder sentence = new StringBuilder();
            for (int i = 0; i < feature.getWordCount(); i ++) {
                int wordLength = Randomizer.rand(feature.getMinWordLength(),feature.getMaxWordLength());
                StringBuilder word = new StringBuilder();
                for (int j = 0; j < wordLength; j++) {
                    switch (type) {
                        case LETTER_SPAM:
                            word.append(new Randomizer<>(DefaultSentenceComponents.ALPHABET).pickRand());
                            break;
                        case EMOJI_SPAM:
                            word.append(new Randomizer<>(DefaultSentenceComponents.EMOJIS).pickRand());
                            break;
                        case UNICODE_SPAM:
                            word.append(new Randomizer<>(DefaultSentenceComponents.UNICODES).pickRand());
                            break;
                    }
                }
                sentence.append(word).append(" ");
            }
            result = sentence.toString().trim().concat(".");
        }
        return result;
    }
}
