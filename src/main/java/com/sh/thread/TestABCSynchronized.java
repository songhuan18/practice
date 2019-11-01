package com.sh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 开启三个线程，分别交替打印A，B，C。打印10遍
 * @author sh
 * @date 2019-10-28 16:34
 */
public class TestABCSynchronized {
    private static Object o = new Object();
    private volatile static int status = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (o) {
                    while (status != 1) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A " + i + " 次");
                    status = 2;
                    o.notifyAll();
                }
            }
        });

        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (o) {
                    while (status != 2) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B " + i + " 次");
                    status = 3;
                    o.notifyAll();
                }
            }
        });

        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (o) {
                    while (status != 3) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C " + i + " 次");
                    status = 1;
                    o.notifyAll();
                }
            }
        });

        executorService.shutdown();
    }
}