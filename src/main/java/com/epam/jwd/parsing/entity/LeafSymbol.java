package com.epam.jwd.parsing.entity;

import java.util.Arrays;
import java.util.List;

public class LeafSymbol implements Component {
    private String symbol;

    public LeafSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Component element) {

    }

    @Override
    public List<Component> getComponents() {
        return Arrays.asList(this);
    }

    @Override
    public String getString() {
        return symbol;
    }

    @Override
    public void remove(Component element) {

    }

    @Override
    public String toString() {
        return "LeafSymbol{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafSymbol)) return false;

        LeafSymbol that = (LeafSymbol) o;

        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }
}
