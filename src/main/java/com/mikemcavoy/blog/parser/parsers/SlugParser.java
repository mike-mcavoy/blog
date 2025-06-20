package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;
import com.mikemcavoy.blog.tokenizer.Token;
import com.mikemcavoy.blog.tokenizer.TokenType;

public class SlugParser extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        boolean found = this.findTypes(tokens, new ArrayList<TokenType>(
                Arrays.asList(TokenType.TEXT, TokenType.COLON, TokenType.TEXT, TokenType.NEWLINE)));

        if (found && tokens.get(0).value().equals("slug")) {
            Node slugNode = new Node();
            slugNode.setType(Type.SLUG);
            slugNode.setValue(tokens.get(2).value().trim());
            slugNode.setConsumed(4);

            return Optional.ofNullable(slugNode);
        }

        return Optional.empty();
    }

}
