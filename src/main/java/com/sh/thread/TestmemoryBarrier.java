package com.sh.thread;

public class TestmemoryBarrier {
    private volatile boolean running = false;

    public boolean get() {
        return running;
    }

    public void doSetTrue() {
        running = true;
    }

    public static void main(String[] args) throws InterruptedException {
        TestmemoryBarrier instance = new TestmemoryBarrier();

        Thread thread = new Thread(() -> {
            while (!instance.get()) {

            }
            System.out.println("Thread 1 finished");
        });
        thread.start();
        thread.start();
        Thread.sleep(100);

        new Thread(() -> {
            instance.doSetTrue();
            System.out.println("Thread 2 finished");
        }).start();
        Thread.sleep(100);
    }
}
