package com.epam.jwd.parsing.sorting;

import java.util.Comparator;

public class ComparatorSupplier {

    private static final ParagraphComparator PARAGRAPH_COMPARATOR = new ParagraphComparator();
    private static final SentenceComparator SENTENCE_COMPARATOR = new SentenceComparator();

    public static ParagraphComparator getParagraphComparator() {
        return PARAGRAPH_COMPARATOR;
    }

    public static SentenceComparator getSentenceComparator() {
        return SENTENCE_COMPARATOR;
    }

    public static LexemeComparator getLexemeComparator(String symbol) {
        return new LexemeComparator(symbol);
    }
}
