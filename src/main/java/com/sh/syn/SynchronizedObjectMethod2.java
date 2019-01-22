package com.sh.syn;

/**
 * 对象锁，方法形式
 */
public class SynchronizedObjectMethod2 implements Runnable {

    private static SynchronizedObjectMethod2 instance = new SynchronizedObjectMethod2();
    private static SynchronizedObjectMethod2 instance2 = new SynchronizedObjectMethod2();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
//        Thread t2 = new Thread(instance2); # synchronized是无法锁住的
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
