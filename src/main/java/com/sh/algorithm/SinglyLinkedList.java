package com.sh.algorithm;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 * @author sh
 * @date 2020/9/4 10:45 上午
 */
public class SinglyLinkedList {

    private Node head = null;

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    // 顺序插入，链表尾部插入
    public void insertToTail(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = node;
        }
    }

    // 通过data查找节点
    public Node findByData(int data) {
        Node p = head;
        while (p != null && p.data != data) {
            p = p.next;
        }
        return p;
    }

    // 通过index查询
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    // 把节点插入指定节点之后
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    // 把节点插入指定节点之前
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while(q != null && q.next != p) {
            q = q.next;
        }
        newNode.next = p;
        q.next = newNode;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        int data[] = {1,2};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 0; i < data.length; i++) {
            singlyLinkedList.insertToTail(new Node(data[i], null));
        }
        System.out.println(singlyLinkedList.findByIndex(1).getData());
    }
}
