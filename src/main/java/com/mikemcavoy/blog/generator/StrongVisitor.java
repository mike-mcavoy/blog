package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public class StrongVisitor implements Visitor {

    @Override
    public String visit(Node node) {
        return "<b>" + node.getValue() + "</b>";
    }

}
