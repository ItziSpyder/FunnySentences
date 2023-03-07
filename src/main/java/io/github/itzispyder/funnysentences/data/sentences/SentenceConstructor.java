package io.github.itzispyder.funnysentences.data.sentences;

import io.github.itzispyder.funnysentences.util.ArgBuilder;
import io.github.itzispyder.funnysentences.util.Randomizer;
import org.apache.commons.lang3.StringUtils;
import java.util.Random;

/**
 * Constructs sentences
 */
public abstract class SentenceConstructor {
    private static String[][][] SentenceStructures = new String[][][] {
        new String[][] {
            DefaultSentenceComponents.SUBJECTS,
            DefaultSentenceComponents.ADJECTIVES,
            DefaultSentenceComponents.NOUNS,
            DefaultSentenceComponents.VERBS,
            DefaultSentenceComponents.SUBJECTS,
            DefaultSentenceComponents.ADJECTIVES,
            DefaultSentenceComponents.NOUNS,
            DefaultSentenceComponents.PREPOSITIONS,
            DefaultSentenceComponents.SUBJECTS,
            DefaultSentenceComponents.ADJECTIVES,
            DefaultSentenceComponents.PLACES,
            DefaultSentenceComponents.CONJUNCTIONS,
            DefaultSentenceComponents.SUBJECTS,
            DefaultSentenceComponents.ADJECTIVES,
            DefaultSentenceComponents.NOUNS,
            DefaultSentenceComponents.VERBS
        },
        new String[][] {
            DefaultSentenceComponents.SUBJECTS,
            DefaultSentenceComponents.VERBS,
            DefaultSentenceComponents.NOUNS
        }
    };
    
    /**
     * Generates a sentence with a sentence generator and a sentence feature
     * Sentence features will be IGNORED for NORMAL sentence generator
     * @param type generator
     * @param feature feature
     * @return generated sentence
     */
    public static String generate(SentenceGenerator type, SentenceFeature feature) {
        List<String> options = null;
        switch (type) {
            // case without break will fall through
            case LETTER_SPAM:
                return spam(DefaultSentenceComponents.ALPHABET, feature.getWordCount(), feature.getMinWordLength(), feature.getMaxWordLength());
            case EMOJI_SPAM:
                return spam(DefaultSentenceComponents.EMOJIS, feature.getWordCount(), feature.getMinWordLength(), feature.getMaxWordLength());
            case UNICODE_SPAM:
                return spam(DefaultSentenceComponents.UNICODES, feature.getWordCount(), feature.getMinWordLength(), feature.getMaxWordLength());
            case NORMAL:
                return normalSentence();
        }

        throw new Exception("unexpected");
    }

    private static String spam(List<String> options, int wordCount, int minWordLength, int maxWordLength) {
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i ++) {
            int wordLength = Randomizer.rand(minWordLength, maxWordLength);
            String[] word = new String[wordLength];

            for (int j = 0; j < wordLength; j++) {
                word[j] = new Randomizer<>(options).pickRand();
            }

            words[i] = StringUtils.join(word, '');
        }
        
        return String.join(" ", words);
    }

    private static String normalSentence() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        foreach(String[] struct : SentenceStructures[rand.nextInt(SentenceStructures.length)]) {
            sb.append(struct[rand.nextInt(struct.length)]).append(" ");
        }
        return sb.toString().trim() + ".";
    }
}
