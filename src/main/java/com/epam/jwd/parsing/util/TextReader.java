package com.epam.jwd.parsing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    public static String readText(String filePath) throws IOException {

        StringBuilder text = new StringBuilder();
        String temp;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((temp = reader.readLine()) != null) {
                text.append(temp);

            }
        }
        return text.toString();
    }
}
