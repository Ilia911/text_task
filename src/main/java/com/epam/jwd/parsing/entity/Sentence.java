package com.epam.jwd.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component {
    private final List<Component> lexemes = new ArrayList<>();

    @Override
    public void add(Component element) {
        lexemes.add(element);

    }

    @Override
    public List<Component> getComponents() {
        return lexemes;
    }

    @Override
    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Component component : lexemes) {
            stringBuilder.append(component.getString());
        }
        return stringBuilder.toString();
    }

    @Override
    public void sort() {

    }

    @Override
    public void remove(Component element) {

    }

    @Override
    public String toString() {
        return "Sentence{" +
                "lexemes=" + lexemes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        return lexemes != null ? lexemes.equals(sentence.lexemes) : sentence.lexemes == null;
    }

    @Override
    public int hashCode() {
        return lexemes != null ? lexemes.hashCode() : 0;
    }
}
