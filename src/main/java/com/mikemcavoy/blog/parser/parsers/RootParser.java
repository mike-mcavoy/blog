package com.mikemcavoy.blog.parser.parsers;

import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;

public class RootParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        MatchResult result = this.matchStar(tokens, new ElementParser());

        if (result.nodes().isEmpty()) {
            return Optional.empty();
        }

        Node rootNode = new Node();
        rootNode.setType(Type.ROOT);
        rootNode.setConsumed(result.consumed());

        for (Node node : result.nodes()) {
            rootNode.addChildNode(node);
        }

        return Optional.ofNullable(rootNode);
    }

}
