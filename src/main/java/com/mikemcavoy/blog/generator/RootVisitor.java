package com.mikemcavoy.blog.generator;

import java.util.Map;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;

public class RootVisitor implements Visitor {

    private final Map<Type, Visitor> rootVisitors = Map.ofEntries(
            Map.entry(Type.PARAGRAPH, new ParagraphVisitor()),
            Map.entry(Type.EMPTYLINE, new EmptyLineVisitor()));

    @Override
    public String visit(Node node) {

        String result = "";

        for (Node child : node.getChildren()) {
            result += getVisitor(child).visit(child);
        }

        return result;
    }

    private Visitor getVisitor(Node node) {
        return rootVisitors.get(node.getType());
    }

}
