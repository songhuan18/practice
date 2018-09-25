package com.sh;

import java.util.ArrayList;
import java.util.List;

/**
 * parallelStream和Stream遍历性能对比
 */
public class ParallelStreamTest {

    private static final int COUNT = 1000000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            list.add(i);
        }
        long start1 = System.currentTimeMillis();
        for (Integer i : list) {
            if (i.equals(COUNT - 1)) {
                System.out.println("foreach遍历完成");
            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println("耗时：" + (end1 - start1) + "ms");
        long start2 = System.currentTimeMillis();
        list.parallelStream().forEach(n -> {
            if (n.equals(COUNT - 1)) {
                System.out.println("parallel stream遍历完成");
            }
        });
        long end2 = System.currentTimeMillis();
        System.out.println("耗时：" + (end2 - start2) + "ms");
        long start3 = System.currentTimeMillis();
        list.forEach(n -> {
            if (n.equals(COUNT - 1)) {
                System.out.println("stream遍历完成");
            }
        });
        long end3 = System.currentTimeMillis();
        System.out.println("耗时：" + (end3 - start3) + "ms");
    }
}
