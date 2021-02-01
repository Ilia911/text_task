package com.epam.jwd.parsing;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.service.Parser;
import com.epam.jwd.parsing.service.TextParser;
import com.epam.jwd.parsing.sorting.ComparatorSupplier;
import com.epam.jwd.parsing.sorting.LexemeComparator;
import com.epam.jwd.parsing.util.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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

    public void init() {
        String text = readFile();
        component = createComponent(text);
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


}
