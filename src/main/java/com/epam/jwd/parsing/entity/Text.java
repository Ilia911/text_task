package com.epam.jwd.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component {

    private final List<Component> components = new ArrayList<>();

    @Override
    public void add(Component element) {
        components.add(element);
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.getString());
        }
        return stringBuilder.toString();
    }

    @Override
    public void remove(Component element) {
        components.remove(element);
    }

    @Override
    public String toString() {
        return "Text{" +
                "components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return components.equals(text.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }
}
