package com.epam.jwd.parsing.service.sorting;

import com.epam.jwd.parsing.entity.Component;

import java.util.Comparator;

public class LexemeComparator implements Comparator<Component> {

    private final String regex;

    public LexemeComparator(String regex) {
        this.regex = regex;
    }

    @Override
    public int compare(Component o1, Component o2) {

        int quantityOfRegexInComponentO1 = calculateNumberOfRegexInWord(o1);
        int quantityOfRegexInComponentO2 = calculateNumberOfRegexInWord(o2);

        if (quantityOfRegexInComponentO1 != quantityOfRegexInComponentO2) {
            return quantityOfRegexInComponentO2 - quantityOfRegexInComponentO1;
        }

        return o1.getString().compareToIgnoreCase(o2.getString());
    }

    private int calculateNumberOfRegexInWord(Component component) {
        int result = 0;
        for (Component leafSymbol : component.getComponents()) {
            if (leafSymbol.getString().equals(regex)) {
                result++;
            }
        }
        return result;
    }

}
