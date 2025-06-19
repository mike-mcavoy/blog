package com.mikemcavoy.blog.generator;

import com.mikemcavoy.blog.parser.Node;

public class ParagraphVisitor implements Visitor {
    private final Visitor sentenceVisitor = new SentenceVisitor();

    @Override
    public String visit(Node node) {
        String result = "";

        for (Node child : node.getChildren()) {
            result += sentenceVisitor.visit(child);
        }

        return "<p>" + result + "</p>";
    }

}
