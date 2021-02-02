package com.epam.jwd.parsing.service.parser;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.Text;

public class TextParser implements Parser {
    private static final Parser INSTANCE = new TextParser();
    private final Parser nextParser = ParagraphParser.getINSTANCE();

    private TextParser() {
    }

    public static Parser getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Component handleRequest(String text) {
        Component textComponent = new Text();

        String[] paragraphs = text.trim().split(" {4}");
        for (String paragraph : paragraphs) {
            textComponent.add(nextParser.handleRequest(paragraph));
        }
        return textComponent;
    }
}
