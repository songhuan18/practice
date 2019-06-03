package com.sh.thread;

public class YieldTest {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " in control");
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "in control");
        }
    }
}
