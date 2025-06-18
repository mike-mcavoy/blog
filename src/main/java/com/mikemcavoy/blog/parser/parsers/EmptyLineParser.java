package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public class EmptyLineParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        boolean found = this.findTypes(tokens, new ArrayList<TokenType>(Arrays.asList(TokenType.EMPTYLINE)));

        if (found) {
            Node textNode = new Node();
            textNode.setType(Type.EMPTYLINE);
            textNode.setConsumed(1);

            return Optional.ofNullable(textNode);
        }

        return Optional.empty();
    }

}
