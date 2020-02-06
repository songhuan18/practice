package com.sh.thread.pool;

import java.util.concurrent.*;

/**
 * ThreadExecutor 七大参数
 * 1.corePoolSize: 线程池中的常驻核心线程数
 * 2.maximumPoolSize: 线程池能够容纳同时执行的最大线程数，此值必须大于等于1
 * 3.keepAliveTime: 多余的空闲线程的存活时间，当前线程池数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，多余空闲线程会被销毁直到
 * 只剩下corePoolSize个线程为止
 * 4.unit: keepAliveTime的单位
 * 5.workQueue: 任务队列，被提交但尚未被执行的任务
 * 6.threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程，一般用默认即可
 * 7.handler: 拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数（maximumPoolSize）
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService threadPool = new ThreadPoolExecutor(
//                2,
//                5,
//                1L,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
//        try {
//            for (int i = 0; i < 8; i++) {
//                threadPool.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            threadPool.shutdown();
//        }
//        threadPoolInit();

        PauseThreadPoolExecutor executor = new PauseThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("thread name is: " + Thread.currentThread().getName());
            });
        }
        System.out.println(executor.getActiveCount());
        executor.shutdown();
        System.out.println(executor.isShutdown());
//        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void threadPoolInit() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建固定线程数，一池5个处理线程，执行长期的任务，性能很好
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//创建一个线程，一池1个线程，一个任务一个任务执行的场景
//        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个线程，执行短期异步的小程序或者负载较轻的任务

        ExecutorService threadPool = new ThreadPoolExecutor(1, 100, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        // 模拟10个用户，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10000; i++) {
                int temp  = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务 " + temp);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
