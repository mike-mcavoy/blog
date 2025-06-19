package com.mikemcavoy.blog.generator;

import java.util.Map;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;

public class SentenceVisitor implements Visitor {
    private final Map<Type, Visitor> rootVisitors = Map.ofEntries(
            Map.entry(Type.TEXT, new TextVisitor()),
            Map.entry(Type.STRONG, new StrongVisitor()));

    @Override
    public String visit(Node node) {
        return getVisitor(node).visit(node);
    }

    private Visitor getVisitor(Node node) {
        return rootVisitors.get(node.getType());
    }
}
