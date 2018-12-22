package com.sh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 开启三个线程，分别交替打印A，B，C。打印10遍
 */
public class TestABCAlternate {

    private static Lock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    // 标记，目前该唤醒哪一个线程
    private static volatile int number = 1;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    lock.lock();
                    if (number != 1) {
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " A " + i);
                    number = 2;
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    lock.lock();
                    if (number != 2) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " B " + i);
                    number = 3;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    lock.lock();
                    if (number != 3) {
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " C " + i);
                    number = 1;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        executorService.shutdown();
    }
}
