package com.sh.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1...循环操作5次
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "BBB").start();
    }
}

class ShareData {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int number;

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {// 如果用if判断可能出现虚假唤醒，所以最好是用while判断
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number++;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number--;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
