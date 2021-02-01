package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser {
    private static final Parser INSTANCE = new TextParser();
    private Parser nextParser = ParagraphParser.getINSTANCE();
    private static final Pattern PARAGRAPH_PATTERN = Pattern.compile("^[ {4}\\t].*?");

    private TextParser() {
    }

    public static Parser getINSTANCE() {
        return INSTANCE;
    }

    public Parser getNextParser() {
        return nextParser;
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Component handleRequest(String text) {
        Component textComponent = new Text();
//        List<String> paragraphs = parseText(text);

        String[] paragraphs = text.split(" {4}");
        for (String paragraph : paragraphs) {
            textComponent.add(nextParser.handleRequest(paragraph));
        }
        return textComponent;
    }

    private List<String> parseText(String paragraph) {
        List<String> sentenceList = new ArrayList<>();
        final Matcher matcher = PARAGRAPH_PATTERN.matcher(paragraph);

        while (matcher.find()) {
            sentenceList.add(matcher.group());
        }
        return sentenceList;
    }
}
