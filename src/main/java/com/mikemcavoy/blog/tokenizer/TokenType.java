package com.mikemcavoy.blog.tokenizer;

public enum TokenType {
    HASHTAG("#"),
    TEXT(""),
    STAR("*"),
    NEWLINE("\n"),
    EMPTYLINE(""),
    EOF(""),
    HYPEN("-"),
    COLON(":");

    public final String value;

    TokenType(String value) {
        this.value = value;
    }
}
