package com.sh.thread;

import java.util.concurrent.TimeUnit;

/**
 * 测试最大支持的线程数
 * @author sh
 * @date 2020-02-04 15:09
 */
public class TestMaxSupportThreads {

    public static void main(String[] args) {
//        System.out.println("开始垃圾回收");
//        System.gc();
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 0;
//        try {
//            while (true) {
//                i++;
//                final int temp = i;
//                new Thread(() -> {
////                    System.out.println("执行i：" + temp);
//                    try {
//                        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }, "thread-" + i).start();
//            }
//        } catch (Throwable e) {
//            System.out.println("最大创建线程数为：" + i);
//            e.printStackTrace();
//        }

    }
}
