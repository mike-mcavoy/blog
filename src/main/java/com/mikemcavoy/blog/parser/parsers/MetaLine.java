package com.mikemcavoy.blog.parser.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.tokenizer.Token;

public class MetaLine extends BaseParser {

    @Override
    public Optional<Node> match(List<Token> tokens) {
        return matchFirst(tokens, new ArrayList<>(Arrays.asList(
                new SlugParser(),
                new CreatedParser())));
    }

}
