package com.epam.jwd.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component {
    private List<Component> sentences = new ArrayList<>();

    @Override
    public void add(Component element) {
        sentences.add(element);

    }

    @Override
    public List<Component> getComponents() {
        return sentences;
    }

    @Override
    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t");

        for (Component sentence : sentences) {
            stringBuilder.append(sentence.getString());
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n");

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
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph)) return false;

        Paragraph paragraph = (Paragraph) o;

        return sentences != null ? sentences.equals(paragraph.sentences) : paragraph.sentences == null;
    }

    @Override
    public int hashCode() {
        return sentences != null ? sentences.hashCode() : 0;
    }
}
