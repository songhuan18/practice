package com.sh.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，读写分离
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache map = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> map.set(String.valueOf(temp), String.valueOf(temp)), String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> map.get(String.valueOf(temp)), String.valueOf(i)).start();
        }
    }
}

class MyCache {
    Map<String, Object> map = new HashMap<>();
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void set(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            // 让线程暂停一会儿
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：");
            // 让线程暂停一会儿
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
