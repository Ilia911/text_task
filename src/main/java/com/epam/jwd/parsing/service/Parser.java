package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;

import java.util.List;

public interface Parser {
    Component handleRequest(String string);

}
