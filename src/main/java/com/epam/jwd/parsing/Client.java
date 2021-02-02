package com.epam.jwd.parsing;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.service.interpreter.ExpressionInterpreterClient;
import com.epam.jwd.parsing.service.interpreter.PolishParser;
import com.epam.jwd.parsing.service.parser.Parser;
import com.epam.jwd.parsing.service.parser.TextParser;
import com.epam.jwd.parsing.service.sorting.ComparatorSupplier;
import com.epam.jwd.parsing.service.sorting.LexemeComparator;
import com.epam.jwd.parsing.util.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private String filePath;
    private Component component;
    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    private static final Client INSTANCE = new Client();

    {
        filePath = "src/main/resources/input/text.txt";
    }

    private Client() {
    }

    public static Client getInstance() {
        return INSTANCE;
    }

    public String sortParagraphsByQuantityOfSentences() {

        component.getComponents().sort(ComparatorSupplier.getParagraphComparator());
        return component.getString();
    }

    public String sortSentencesByLexemeLength() {

        for (Component paragraphs : component.getComponents()) {
            for (Component sentences : paragraphs.getComponents()) {
                sentences.getComponents().sort(ComparatorSupplier.getSentenceComparator());
            }
        }
        return component.getString();
    }

    public String sortLexemeByQuantityOfSymbol(String symbol) {

        final LexemeComparator comparator = ComparatorSupplier.getLexemeComparator(symbol);

        for (Component paragraphs : component.getComponents()) {
            for (Component sentences : paragraphs.getComponents()) {
                sentences.getComponents().sort(comparator);
            }
        }
        return component.getString();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void init() {
        String text = readFile();
        text = replaceMathExpressionsByResult(text);
        component = createComponent(text);

    }

    private String replaceMathExpressionsByResult(String text) {

        List<String> expressions = findExpressions(text);
        List<String> results = calculateResults(expressions);

        for (int i = 0; i < expressions.size(); i++) {
            Pattern pattern = Pattern.compile("[^A-Za-z !?.,'’]+[^A-Za-z !?.,'’]");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (matcher.group().equals(expressions.get(i)))
                text = matcher.replaceFirst(results.get(i));
            }
        }
        return text;
    }

    private List<String> calculateResults(List<String> expressions) {
        List<String> results = new ArrayList<>();

        for (String expression : expressions) {
            String[] postfixExpression = PolishParser.infixToRPN(expression.split(""));
            results.add(String.valueOf(new ExpressionInterpreterClient().parse(postfixExpression)));

        }
        return results;
    }

    private List<String> findExpressions(String text) {
        Pattern pattern = Pattern.compile("[^A-Za-z !?.,'’]+[^A-Za-z !?.,'’]");
        Matcher matcher = pattern.matcher(text);
        List<String> expressions = new ArrayList<>();
        while (matcher.find()) {
            expressions.add(matcher.group());
        }
        return expressions;
    }

    private Component createComponent(String text) {
        Parser parser = TextParser.getINSTANCE();
        return parser.handleRequest(text);
    }

    private String readFile() {
        String text = "";
        try {
            text = TextReader.readText(filePath);
        } catch (IOException e) {
            LOGGER.error("Initialization failed");
        }
        return text;
    }


    @Override
    public String toString() {
        return component.getString();
    }
}
