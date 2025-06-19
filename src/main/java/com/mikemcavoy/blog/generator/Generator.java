package com.mikemcavoy.blog.generator;

import java.util.List;

import com.mikemcavoy.blog.parser.Node;
import com.mikemcavoy.blog.parser.Type;

public class Generator {
    public static CompiledPost generateHtmlString(Node ast) {
        String slug = "";
        String created = "";
        String htmlString;

        if (ast.getChildren().get(0).getType() == Type.META) {
            List<Node> metaNodes = ast.getChildren().remove(0).getChildren();
            for (Node metaNode : metaNodes) {
                switch (metaNode.getType()) {
                    case Type.SLUG:
                        slug = metaNode.getValue();
                        break;

                    case Type.CREATED:
                        created = metaNode.getValue();
                        break;

                    default:
                        break;
                }
            }
        }

        htmlString = new RootVisitor().visit(ast);

        return new CompiledPost(slug, created, htmlString);
    }

    public record CompiledPost(String slug, String created, String htmlString) {
    }
}
