package com.sh.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HashMapTest {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        try {
            for (int i = 0; i < 50; i++) {
                final int temp = i;
                poolExecutor.execute(() -> {
                    for (int j = 0; j < 50; j++) {
                        map.put(UUID.randomUUID().toString(), temp);
                    }
                });
            }
        } finally {
            poolExecutor.shutdown();
        }
        while (Thread.activeCount() > 2) {
            System.out.println("线程数：" + Thread.activeCount());
        }
        System.out.println(map.size());
    }
}
