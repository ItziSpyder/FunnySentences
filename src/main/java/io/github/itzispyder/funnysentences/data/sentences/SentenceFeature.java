package io.github.itzispyder.funnysentences.data.sentences;

/**
 * Sentence features
 */
public class SentenceFeature {

    private int wordCount, maxWordLength, minWordLength;

    /**
     * Sentence features DEFAULT
     */
    public SentenceFeature() {
        this(15,1,10);
    }

    /**
     * Sentence features CUSTOM
     * @param wordCount word count
     * @param maxWordLength max length a word can hold up to
     * @param minWordLength min length a word can hold up to
     */
    public SentenceFeature(int wordCount, int minWordLength, int maxWordLength) {
        if (wordCount <= 0)
            throw new IllegalArgumentException("Word count cannot be less than or equal to 0");
        if (minWordLength > maxWordLength)
            throw new IllegalArgumentException("minWordLength cannot be greater than maxWordLength");
        this.wordCount = wordCount;
        this.maxWordLength = maxWordLength;
        this.minWordLength = minWordLength;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setMaxWordLength(int maxWordLength) {
        this.maxWordLength = maxWordLength;
    }

    public void setMinWordLength(int minWordLength) {
        this.minWordLength = minWordLength;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
