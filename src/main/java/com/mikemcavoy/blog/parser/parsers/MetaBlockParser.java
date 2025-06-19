package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public class MetaBlockParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        int consumed = 0;

        boolean top = this.findTypes(tokens,
                new ArrayList<TokenType>(Arrays.asList(
                        TokenType.HYPEN, TokenType.HYPEN, TokenType.HYPEN, TokenType.NEWLINE)));

        if (!top) {
            return Optional.empty();
        }

        consumed += 4;

        MatchResult result = matchStar(tokens.subList(consumed, tokens.size()), new MetaLine());
        List<Node> nodes = result.nodes();

        if (nodes.isEmpty()) {
            return Optional.empty();
        }

        consumed += result.consumed();

        boolean bottom = this.findTypes(tokens.subList(consumed, tokens.size()),
                new ArrayList<TokenType>(Arrays.asList(
                        TokenType.HYPEN, TokenType.HYPEN, TokenType.HYPEN, TokenType.NEWLINE)));

        if (!bottom) {
            return Optional.empty();
        }

        consumed += 4;

        Node metaNode = new Node();
        metaNode.setType(Type.META);
        metaNode.setConsumed(consumed);

        for (Node node : nodes) {
            metaNode.addChildNode(node);
        }

        return Optional.ofNullable(metaNode);
    }

}
