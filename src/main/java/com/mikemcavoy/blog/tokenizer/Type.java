package com.mikemcavoy.blog.tokenizer;

public enum Type {
    HASHTAG("#"),
    TEXT(""),
    STAR("*"),
    NEWLINE("\n"),
    EMPTYLINE(""),
    EOF("");

    public final String value;

    Type(String value) {
        this.value = value;
    }
}
