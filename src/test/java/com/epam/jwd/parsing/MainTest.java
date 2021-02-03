package com.epam.jwd.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
    private static final Logger LOGGER = LogManager.getLogger(MainTest.class);
    private static Client client = Client.getInstance();
    @BeforeClass
    public static void init() {
        final String expected = "    Hello my friends! Ab aab baaa caa Abca.\n" +
                "    Today is a nice day! Do you think so? A ba ab faa caa aca.\n" +
                "    I want to calculate this expression: 2+5-(3+1)*2+4/2 for you...";

        LOGGER.info("filePath: src/test/resources/input/text.txt");
        LOGGER.info("original text:");
        LOGGER.info(expected);

        client.setFilePath("src/test/resources/input/text.txt");

        client.init();
        final String actual = client.toString();

        LOGGER.info("Text after initialization:");
        LOGGER.info(actual);

    }

    @Test
    public void checkAllFunctions_shouldLogAllActions_always() {
        client.sortParagraphsByQuantityOfSentences();
        LOGGER.info("Text after paragraph sorting:");
        LOGGER.info(client.toString());

        client.sortSentencesByLexemeLength();
        LOGGER.info("Text after sentences sorting by lexeme length:");
        LOGGER.info(client.toString());

        client.sortLexemeByQuantityOfSymbol("a");
        LOGGER.info("Text after lexeme sorting by symbol 'a':");
        LOGGER.info(client.toString());

    }
}
