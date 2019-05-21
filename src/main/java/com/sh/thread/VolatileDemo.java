package com.sh.thread;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MyData myData = new MyData();
        for (int i = 1; i <=20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程全部计算完成之后，再用main线程查看num的结果值是多少
        while (Thread.activeCount() > 2) {// 为什么大于2，因为默认后台有两个线程，一个是主线程，一个是GC线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " finally number value: " + myData.num);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end -start));
    }

    // volatile 可以保证可见性，及时通知其它线程主物理内存的值已经改变
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName() + " come in");
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + " update number value: " + myData.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        int index = 0;
        while (myData.num == 0) {
            if (index < 10) {
                System.out.println("===========" + index);
                index++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " main thread over, number value: " + myData.num);
    }
}

class MyData {
    volatile int num = 0;

    void addTo60() {
        this.num = 60;
    }

     void addPlusPlus() {
        num++;
    }
}
