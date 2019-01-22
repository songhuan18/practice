package com.sh.syn;

/**
 * 类锁的第一种形式，static形式(全局同步)
 */
public class SynchronizedClassStatic3 implements Runnable {

    private static SynchronizedClassStatic3 instance1 = new SynchronizedClassStatic3();
    private static SynchronizedClassStatic3 instance2 = new SynchronizedClassStatic3();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished " + Thread.currentThread().getName());
    }

    public static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static形式。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    @Override
    public void run() {
        method();
    }
}
