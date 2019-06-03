package com.sh.thread;

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
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMes();
        }).start();
        new Thread(() -> {
            phone.sendEmail();
        }).start();
    }
}
