package com.mikemcavoy.blog.tokenizer;

public record Token(int pos, int line, TokenType type, String value) {
}
