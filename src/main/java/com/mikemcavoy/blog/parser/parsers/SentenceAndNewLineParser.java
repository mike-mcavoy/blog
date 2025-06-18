package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public class SentenceAndNewLineParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        MatchResult result = matchStar(tokens, new SentenceParser());
        List<Node> nodes = result.nodes();
        int consumed = result.consumed();

        if (nodes.isEmpty()) {
            return Optional.empty();
        }

        boolean foundNewLine = this.findTypes(
                tokens.subList(consumed, tokens.size()),
                new ArrayList<TokenType>(Arrays.asList(TokenType.NEWLINE)));

        if (!foundNewLine) {
            return Optional.empty();
        }

        consumed += 1;

        Node paragraphNode = new Node();
        paragraphNode.setType(Type.PARAGRAPH);
        paragraphNode.setConsumed(consumed);

        for (Node node : nodes) {
            paragraphNode.addChildNode(node);
        }

        return Optional.ofNullable(paragraphNode);
    }

}
