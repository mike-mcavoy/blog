package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public class EmptyLineVisitor implements Visitor {

    @Override
    public String visit(Node node) {
        return "<br/>";
    }

}
