package com.mikemcavoy.blog.parser;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Type type;
    private List<Node> children = new ArrayList<Node>();
    private String value;
    private int consumed;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChildNode(Node node) {
        this.children.add(node);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getConsumed() {
        return consumed;
    }

    public void setConsumed(int consumed) {
        this.consumed = consumed;
    }

    @Override
    public String toString() {
        return "Node [type=" + type + ", children=" + children + ", value=" + value + ", consumed=" + consumed + "]";
    }

}
