package com.sh.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockTest {
}

class Phone {
    public synchronized void sendMes() {
        System.out.println(Thread.currentThread().getName() + " sendMes");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " sendEmail");
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Phone phone = new Phone();
        lock.lock();
        new Thread(() -> {
            phone.sendMes();
        }).start();
        new Thread(() -> {
            phone.sendEmail();
        }).start();
        lock.unlock();
    }
}
