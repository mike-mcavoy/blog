package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public class TextVisitor implements Visitor {

    @Override
    public String visit(Node node) {
        return node.getValue();
    }

}
