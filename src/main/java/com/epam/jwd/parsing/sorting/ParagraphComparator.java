package com.epam.jwd.parsing.sorting;

import com.epam.jwd.parsing.entity.Component;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {

        return Integer.compare(o1.getComponents().size(), o2.getComponents().size());
    }
}
