package com.sh;

import java.util.ArrayList;
import java.util.List;

/**
 * ParallelStream 如何造成线程不安全
 * 跑出异常：ArrayIndexOutOfBoundsException
 */
public class ParallelStreamTest2 {

    private static final int COUNT = 1000;

    public static void main(String[] args) {
        List<Integer> srcList = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            srcList.add(i);
        }
        List<Integer> copyList = new ArrayList<>();
        srcList.parallelStream().forEach(n -> copyList.add(n));
        System.out.println("src list size：" + srcList.size());
        System.out.println("copy list size：" + copyList.size());
    }
}
