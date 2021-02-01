package com.epam.jwd.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component {
    private final List<Component> characters = new ArrayList<>();
    @Override
    public void add(Component element) {

    }

    @Override
    public Object getChild(int index) {
        return null;
    }

    @Override
    public void sort() {

    }

    @Override
    public void remove(Component element) {

    }
}
