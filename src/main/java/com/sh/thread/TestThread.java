package com.sh.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author sh
 * @date 2020/8/27 3:14 下午
 */
public class TestThread {

    private static Boolean flag = false;
    private static Integer count = 0;

    private static void refresh() {
        flag = true;
    }

    public static void main(String[] args) {
//        new Thread(() -> {
//            long start = System.currentTimeMillis();
//            while (!flag) {
//            }
//            long end = System.currentTimeMillis();
//            System.out.println("执行完毕了，耗时：" + (end - start));
//        }).start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(() -> {
//            refresh();
//        }).start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("刷新完毕 " + flag);
        LockSupport.park();
    }
}
