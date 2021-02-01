package com.epam.jwd.parsing.service;

import com.epam.jwd.parsing.entity.Component;

public interface Parser {
    Component handleRequest(String string);

}
