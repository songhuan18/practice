package com.sh;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author sh
 * Date 2019-07-19 16:31
 */
public class H2O {
    private Lock lock = new ReentrantLock();
    private Condition conditionH = lock.newCondition();
    private Condition conditionO = lock.newCondition();
    // 1代表H线程2代表O线程
    private int num = 1;

    public static void main(String[] args) {
        new H2O();
    }

    public H2O() {
        String str = "OOHHHHH";
        int len = str.length() / 3;
        for (int i = 0; i < len; i++) {
            try {
                hydrogen(() -> {
                    lock.lock();
                    try {
                        while (num != 1) {
                            conditionH.await();
                        }
                        System.out.print("HH");
                        num = 2;
                        conditionO.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                oxygen(() -> {
                    lock.lock();
                    try {
                        while (num != 2) {
                            conditionO.await();
                        }
                        System.out.print("O");
                        num = 1;
                        conditionH.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
    }
}
