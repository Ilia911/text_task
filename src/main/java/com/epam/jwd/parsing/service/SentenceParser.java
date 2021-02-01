package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.Sentence;
// This class parses paragraphs into Sentence component

public class SentenceParser implements Parser {
    private static final SentenceParser INSTANCE = new SentenceParser();
    private Parser nextParser = LexemeParser.getINSTANCE();


    private SentenceParser() {
    }

    public static SentenceParser getINSTANCE() {
        return INSTANCE;
    }

    public Parser getNextParser() {
        return nextParser;
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Component handleRequest(String sentence) {
        Component sentenceComponent = new Sentence();
        String[] lexemeList = sentence.split(" ");

        for (String lexeme : lexemeList) {
            sentenceComponent.add(nextParser.handleRequest(lexeme));
        }

        return sentenceComponent;
    }
}
