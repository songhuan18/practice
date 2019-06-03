package com.sh;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
////        list.iterator().hasNext()
//        System.out.println(8 >> 2);
        UnidirectionalNode<Integer> u = new UnidirectionalNode<>();
        u.add(1);
        u.add(2);
        System.out.println(u.size());
        u.traverse();
    }
}
