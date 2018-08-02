package com.yg.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            map.put(i, i);
            if (i == 13) {
                System.out.println("打印" + i);
            }
        }
    }
}
