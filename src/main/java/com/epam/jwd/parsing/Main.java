package com.epam.jwd.parsing;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.service.Parser;
import com.epam.jwd.parsing.service.TextParser;
import com.epam.jwd.parsing.util.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        String text = null;

        try {
            text = TextReader.readText("src/main/resources/input/text.txt");
        } catch (IOException e) {
            LOGGER.info("File reading failed!");
        }

        System.out.println(text);

        String text2 = "Hello! MY Frientds?";
        Parser par = TextParser.getINSTANCE();
        final Component component = par.handleRequest(text);

        System.out.println("--------------------");

        System.out.println(component.getString());





    }

}
