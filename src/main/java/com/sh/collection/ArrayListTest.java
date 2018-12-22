package com.sh.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add(10, "apple");// IndexOutOfBoundsException
//        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("orange");
        list2.add("banana");
        list2.add(1, "pear");

        System.out.println(list2);

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                System.out.println(i);
            }
            integers.add(i);
        }
    }
}
