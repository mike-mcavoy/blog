package com.mikemcavoy.blog.tokenizer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lexer {
    private Scanner scanner;
    private boolean isAtEnd;
    private String currentLine;
    private String currentChar;
    private int linePosition = 0;
    private int line = 0;
    private List<Token> tokens = new ArrayList<Token>();

    public List<Token> getTokens() {
        return tokens;
    }

    public Lexer(InputStream stream) {
        this.scanner = new Scanner(stream);
        this.currentLine = this.scanner.nextLine();
        this.currentChar = String.valueOf(this.currentLine.charAt(0));
    }

    private void nextCharacter() {
        if (this.linePosition + 1 >= this.currentLine.length()) {
            this.currentChar = "\n";
            this.linePosition++;
            return;
        }

        this.linePosition++;
        this.currentChar = String.valueOf(this.currentLine.charAt(this.linePosition));
    }

    private void nextLine() {
        if (!this.scanner.hasNext()) {
            this.isAtEnd = true;
            return;
        }

        this.currentLine = this.scanner.nextLine();
        this.line++;

        if (this.currentLine.length() != 0) {
            this.linePosition = 0;
            this.currentChar = String.valueOf(this.currentLine.charAt(this.linePosition));
            return;
        } else {
            this.linePosition = 0;
            this.generateToken(TokenType.EMPTYLINE, "");
        }

        this.nextLine();
    }

    private void generateToken(TokenType type, String value) {
        int position = this.linePosition;

        if (value.length() != 0) {
            position = this.linePosition - value.length();
        }

        this.tokens.add(new Token(position, this.line, type, value));
    }

    public void logTokens() {
        for (Token token : this.tokens) {
            System.out.printf("[%s | %d | %d | %s ]\n",
                    token.type(),
                    token.pos(),
                    token.line(),
                    token.value());
        }
    }

    public void lex() {
        if (this.isAtEnd) {
            this.linePosition++;
            this.generateToken(TokenType.EOF, "");
            return;
        }

        TokenType tokenType;
        String value = "";
        switch (this.currentChar) {
            case "#":
                tokenType = TokenType.HASHTAG;
                break;

            case "*":
                tokenType = TokenType.STAR;
                break;

            case "-":
                tokenType = TokenType.HYPEN;
                break;

            case ":":
                tokenType = TokenType.COLON;
                break;

            case "\n":
                this.generateToken(TokenType.NEWLINE, "");
                this.nextLine();
                this.lex();
                return;

            default:
                boolean exit = false;

                while (!exit) {
                    switch (this.currentChar) {
                        case "#", "*", "\n", "-", ":":
                            exit = true;
                            break;

                        default:
                            value += this.currentChar;
                            this.nextCharacter();
                            break;
                    }
                }

                tokenType = TokenType.TEXT;
                break;

        }

        this.generateToken(tokenType, value);

        if (tokenType != TokenType.TEXT) {
            this.nextCharacter();
        }

        this.lex();
    }
}
