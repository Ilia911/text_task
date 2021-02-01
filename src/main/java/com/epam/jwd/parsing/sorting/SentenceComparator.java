package com.epam.jwd.parsing.sorting;

import com.epam.jwd.parsing.entity.Component;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return o1.getComponents().size() - o2.getComponents().size();
    }
}
