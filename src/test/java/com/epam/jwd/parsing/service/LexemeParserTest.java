package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;
import com.epam.jwd.parsing.entity.LeafSymbol;
import com.epam.jwd.parsing.entity.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTest {

    @Test
    public void handleRequest_shouldReturnLexemeComponent_always() {

        String lexeme = "Hel!";

        Component actual = LexemeParser.getINSTANCE().handleRequest(lexeme);

        //expected:

        Component leafSymbol1 = new LeafSymbol("H");
        Component leafSymbol2 = new LeafSymbol("e");
        Component leafSymbol3 = new LeafSymbol("l");
        Component leafSymbol4 = new LeafSymbol("!");

        Component expected = new Lexeme();
        expected.add(leafSymbol1);
        expected.add(leafSymbol2);
        expected.add(leafSymbol3);
        expected.add(leafSymbol4);

        Assert.assertEquals(expected, actual);

    }
}
