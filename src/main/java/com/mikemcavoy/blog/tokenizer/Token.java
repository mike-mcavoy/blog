package com.mikemcavoy.blog.tokenizer;

public record Token(int pos, int line, Type type, String value) {
}
