package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public abstract class BaseParser {

    public abstract Optional<Node> match(List<Token> tokens);

    public boolean findTypes(List<Token> tokens, List<TokenType> types) {
        for (int i = 0; i < types.size(); i++) {
            if (tokens.get(i).type() != types.get(i)) {
                return false;
            }
        }

        return true;
    }

    public MatchResult matchStar(List<Token> tokens, BaseParser parser) {
        List<Node> matchedNodes = new ArrayList<Node>();
        int consumed = 0;

        while (true) {
            Optional<Node> node = parser.match(new ArrayList<>(tokens.subList(consumed, tokens.size())));

            if (node.isEmpty()) {
                break;
            }

            matchedNodes.add(node.get());
            consumed += node.get().getConsumed();
        }

        return new MatchResult(matchedNodes, consumed);
    }

    public Optional<Node> matchFirst(List<Token> tokens, List<BaseParser> parsers) {
        for (BaseParser parser : parsers) {
            Optional<Node> node = parser.match(tokens);

            if (node.isPresent()) {
                return node;
            }
        }

        return Optional.empty();
    }

    public record MatchResult(List<Node> nodes, int consumed) {
    }

}
