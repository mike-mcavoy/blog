package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public class CreatedParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        boolean found = this.findTypes(tokens, new ArrayList<TokenType>(
                Arrays.asList(TokenType.TEXT, TokenType.COLON, TokenType.TEXT, TokenType.NEWLINE)));

        if (found && tokens.get(0).value().equals("created")) {
            Node createdNode = new Node();
            createdNode.setType(Type.CREATED);
            createdNode.setValue(tokens.get(2).value());
            createdNode.setConsumed(4);

            return Optional.ofNullable(createdNode);
        }

        return Optional.empty();
    }

}
