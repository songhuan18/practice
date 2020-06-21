package com.sh;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class Test {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
//        LocalDate startDate = LocalDate.of(2014, Month.AUGUST, 18);
//        LocalDate endDate = LocalDate.of(2018, Month.OCTOBER, 16);
//
//        System.out.println(startDate.until(endDate, ChronoUnit.DAYS));
//
//        Runnable task = () -> {
//            int i = connectBlocking();
//            System.out.println("hello word " + i);
//        };
//
//        new Thread(task).start();
//        Map<String, Event> map = new HashMap<>();
//        map.put("a", new Event(1, "a"));
//        System.out.println(map);
//        Event a = map.get("a");
//        a.setDescribed("bb");
//        System.out.println(map);
//        Event orDefault = map.getOrDefault("b", new Event(2, "b"));
//        map.put("b", orDefault);
//        System.out.println(map);

//        Set<String> set = new CopyOnWriteArraySet<>();
//        set.add("a");
//        set.add("a");

//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.computeIfAbsent("1",e->{
//            map.putIfAbsent("1", "1key");
//            return "1";
//        });
////        map.put("2", "2");

        String str = "bcd";
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        Collections.sort(list);
        System.out.println(list);

    }

    private static int connectBlocking() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
