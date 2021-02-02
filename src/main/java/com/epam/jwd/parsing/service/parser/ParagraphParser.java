package com.epam.jwd.parsing.service.parser;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.Paragraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {

    private static final Parser INSTANCE = new ParagraphParser();
    private Parser nextParser = SentenceParser.getINSTANCE();
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("[A-Z].+?[.{3}!?]");


    private ParagraphParser() {
    }

    public Parser getNextParser() {
        return nextParser;
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public static Parser getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Component handleRequest(String paragraph) {
        Component paragraphComponent = new Paragraph();
        List<String> sentenceList = parseParagraph(paragraph);
        int i = 0;
        for (String sentence : sentenceList) {
            paragraphComponent.add(nextParser.handleRequest(sentence));
        }
        return paragraphComponent;
    }

    private List<String> parseParagraph(String paragraph) {
        List<String> sentenceList = new ArrayList<>();
        final Matcher matcher = SENTENCE_PATTERN.matcher(paragraph);

        while (matcher.find()) {
            sentenceList.add(matcher.group());
        }
        return sentenceList;
    }

}
