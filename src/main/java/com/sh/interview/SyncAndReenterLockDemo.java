package com.sh.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：synchronized和Lock有什么区别？用心的Lock有什么好处？举例说明
 * 1.原始构成
 *  synchronized是关键字，属于JVM层
 *      monitorenter(底层通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象，只有在同步块或方法中才能调用wait/notify等方法)
 *      monitorexit
 *  Lock是具体类（java.util.concurrent.locks.Lock）是api层面的锁
 * 2.使用方法
 *  synchronized 不需要用户手动释放锁，当synchronized代码执行完成后系统会自动让线程释放对锁的占用
 *  ReentrantLock 则需要用户手动释放锁，若没有主动释放锁，就有可能导致出现死锁现象
 *  需要lock和unlock方法配合try/finally语句块来完成
 *
 * 3.等待是否可中断
 *  synchronized是不可中断的，除非抛出异常或者正常运行完成
 *  ReentrantLock 可中断，1.设置超时时间tryLock(long timeout, TimeUnit unit)
 *                       2.lockInterruptibly()放代码块中，调用interrupt()可中断
 * 4.加锁是否公平
 *  synchronized 非公平锁
 *  ReentrantLock 两者都可以，默认非公平锁，够着方法可以传入boolean值，true为公平锁，false为非公平锁
 *
 * 5.锁绑定多个condition
 *  synchronized没有
 *  ReentrantLock 用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized要么随机唤醒一个线程，要么唤醒全部线程
 *
 * 题目：多线程之间顺序调用，实现A->B->C三个线程启动，要求如下:
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......
 * 循环10轮
 */
public class SyncAndReenterLockDemo {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printAA(i);
            }
        }, "A线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printBB(i);
            }
        }, "B线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printCC(i);
            }
        }, "C线程").start();
    }
}

class Print {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    // 1代表A线程执行，2代表B线程执行，3代表C线程执行
    private int num = 1;

    public void printAA(int index) {
        lock.lock();
        try {
            while (num != 1) {
                conditionA.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t AA \t" + index + "次打印");
            }
            num = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printBB(int index) {
        lock.lock();
        try {
            while (num != 2) {
                conditionB.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t BB \t" + index + "次打印");
            }
            num = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCC(int index) {
        lock.lock();
        try {
            while (num != 3) {
                conditionC.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t CC \t" + index + "次打印");
            }
            num = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
