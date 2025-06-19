package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public class Generator {
    public static String generateHtmlString(Node ast) {
        return new RootVisitor().visit(ast);
    }
}
