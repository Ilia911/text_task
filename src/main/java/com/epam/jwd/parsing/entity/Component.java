package com.epam.jwd.parsing.entity;

import java.util.List;

public interface Component {
    void add(Component element);
    List<Component> getComponents();
    String getString();
    void remove(Component element);
}
