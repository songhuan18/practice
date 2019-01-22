package com.sh.syn;

/**
 * 类锁的第二种形式，*.class
 */
public class SynchronizedClassClass4 implements Runnable {

    private static SynchronizedClassClass4 instance1 = new SynchronizedClassClass4();
    private static SynchronizedClassClass4 instance2 = new SynchronizedClassClass4();

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (SynchronizedClassClass4.class) {
            System.out.println("我是类锁的第二种形式：synchronized(*.class)。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
