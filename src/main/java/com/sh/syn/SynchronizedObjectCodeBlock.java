package com.sh.syn;

/**
 * 对象锁，代码块形式
 */
public class SynchronizedObjectCodeBlock implements Runnable {

    private static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();

    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是lock1。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1部分运行结束");
        }

        synchronized (lock2) {
            System.out.println("我是lock2。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2部分运行结束");
        }
    }
}
