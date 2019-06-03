package com.sh.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentHashMapTest2 {
    public static void main(String[] args) {
        MyCurrentHashMap map = new MyCurrentHashMap();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> map.set(temp, temp), String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> map.clear(), String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> map.get(temp), String.valueOf(i)).start();
        }
    }
}

class MyCurrentHashMap {
    Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public void set(Integer key, Integer value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key + " value：" + value);
        map.put(key, value);
    }

    public void get(Integer key) {
        Integer val = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 正在读取，值为：" + val);
    }

    public void clear() {
        System.out.println(Thread.currentThread().getName() + "\t 正在删除");
        map.clear();
    }
}
