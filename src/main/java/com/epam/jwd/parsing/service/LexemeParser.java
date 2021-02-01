package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.LeafSymbol;
import com.epam.jwd.parsing.entity.Lexeme;
// This class parses sentences into symbols

public class LexemeParser implements Parser {
    private static final LexemeParser LEXEME_PARSER = new LexemeParser();

    private LexemeParser() {

    }

    public static LexemeParser getINSTANCE() {
        return LEXEME_PARSER;
    }

    @Override
    public Component handleRequest(String lexeme) {
        Component lexemeComponent = new Lexeme();
        String[] symbolArray = lexeme.split("");

        for (String symbol : symbolArray) {
            lexemeComponent.add(new LeafSymbol(symbol));
        }
        return lexemeComponent;
    }
}
