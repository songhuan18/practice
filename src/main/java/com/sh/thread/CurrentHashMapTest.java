package com.sh.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CurrentHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            pool.execute(new MyTask(map));
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(map);
    }
}

class MyTask implements Runnable {

    public static final String KEY = "key";
    ConcurrentHashMap<String, Integer> map;

    public MyTask(ConcurrentHashMap<String, Integer> map) {
        this.map = map;
        System.out.println("构造函数");
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.addup();
        }
    }


    private void addup() {
        synchronized (MyTask.class) {
            if (!map.containsKey(KEY)) {
                map.put(KEY, 1);
            } else {
                map.put(KEY, map.get(KEY) + 1);
            }
        }
    }
}
