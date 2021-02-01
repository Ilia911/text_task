package com.epam.jwd.parsing;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.util.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Client {
    private String filePath;
    private static Component component;
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    public Client() {
    }

    public void init(String filePath) {
        this.filePath = filePath;
        String text = "";
        try {
            text = TextReader.readText(filePath);
        } catch (IOException e) {
            LOGGER.error("Initialization failed");
        }
    }

    public void sortParagraphsByQuantityOfSentences() {

    }

    public void sortSentencesByLexemeLength() {

    }

    public void sortLexemeByQuantityOfSymbol(String symbol) {

    }


}
