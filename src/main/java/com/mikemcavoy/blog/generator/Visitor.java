package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public interface Visitor {
    public String visit(Node node);
}
