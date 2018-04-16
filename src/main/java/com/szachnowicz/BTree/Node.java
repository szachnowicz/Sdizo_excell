package com.szachnowicz.BTree;

public class Node<T extends Comparable<?>> {
    public Node<T> left, right;
    public T value;

    public Node(T data) {
        this.value = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}