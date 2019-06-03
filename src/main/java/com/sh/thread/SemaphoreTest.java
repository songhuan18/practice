package com.sh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    // 假设有50个同时来到酸奶店门口
    private static int clientTotal = 50;
    // 酸奶店只能容纳10个人同时挑选酸奶
    private static int threadTotal = 10;


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            exec.execute(() -> {
                try {
                    // 有"号"的才能进酸奶店挑选购买
                    semaphore.acquire();

                    System.out.println("顾客" + finalI + "在挑选商品，购买...");

                    // 假设挑选了xx长时间，购买了
                    Thread.sleep(1000);

                    // 归还一个许可，后边的就可以进来购买了
                    System.out.println("顾客" + finalI + "购买完毕了...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        exec.shutdown();
    }
}
