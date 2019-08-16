package com.sh.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Author sh
 * Date 2019-07-16 17:21
 */
public class TestArrayList {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    list.add(j);
                    countDownLatch.countDown();
                }
            }, "" + i).start();
        }
        countDownLatch.await();
        System.out.println(list.size());
    }
}
