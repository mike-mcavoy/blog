package com.mikemcavoy.blog.parser;

import java.util.List;

import com.mikemcavoy.blog.parser.parsers.RootParser;
import com.mikemcavoy.blog.tokenizer.Token;

public class Parser {
    private List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Node parse() {
        RootParser root = new RootParser();
        return root.match(tokens).get();
    }

}
