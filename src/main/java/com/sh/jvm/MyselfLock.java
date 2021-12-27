package com.sh.jvm;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sh
 * @date 2021/12/16 8:35 上午
 */
public class MyselfLock {
    private Unsafe unsafe;
    private long valueOffset;
    private volatile int value;

    public MyselfLock() {
        Class<Unsafe> unsafeClass = Unsafe.class;
        try {
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            this.unsafe = (Unsafe) theUnsafe.get(null);
            this.valueOffset = this.unsafe.objectFieldOffset(getClass().getDeclaredField("value"));
            System.out.println("valueOffset: " + valueOffset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lock() {
        for (; ;) {
            if (unsafe.compareAndSwapInt(this, valueOffset, 0, 1)) {
                return;
            }
            Thread.yield();
        }
    }

    public void unLock() {
        value = 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        MyselfLock lock = new MyselfLock();
        long start = System.currentTimeMillis();
        list.parallelStream().forEach(r -> {
//            System.out.println(Thread.currentThread().getName());
//            lock.lock();
            map.put(r, r);
//            lock.unLock();
        });
        System.out.println(map.size());
        long end = System.currentTimeMillis();
        System.out.println("最终耗时: " + (end - start));
        System.out.println( 1 << 13);
    }

}
