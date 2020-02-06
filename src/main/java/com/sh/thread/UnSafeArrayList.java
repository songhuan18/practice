package com.sh.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UnSafeArrayList {
    private static AAA a = new AAA();
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i <= 30; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(list);
//            }).start();
//        }
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("aa");
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        for (int i = 1; i < 30; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                map.put(finalI, finalI);
//                System.out.println(map.size());
//            }).start();
//        }
        System.out.println("abc".getBytes().length);
    }
}

class AAA {

}
