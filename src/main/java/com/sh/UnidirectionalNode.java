package com.sh;

public class UnidirectionalNode<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E e) {
        final Node<E> l = last;
        Node<E> node = new Node<>(e, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    public void traverse() {
        Node<E> node = first;
        while (node != null) {
            System.out.println("开始遍历" + node.item);
            node = node.next;
        }
    }

    public int size() {
        return size;
    }


    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }



}
