package com.sh.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 * @date 2020-03-10 09:23
 */
public class TestThreadPoolException {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        try {
            for (int i = 0; i < 10; i++) {
                final int temp = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().hashCode());
                    if (temp == 9) {
                        throw new RuntimeException("运行时异常");
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadPool.execute(() -> {
            System.out.println("异常之后：" + Thread.currentThread().hashCode());
        });
    }
}
