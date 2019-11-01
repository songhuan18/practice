package com.sh.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sh
 * @date 2019-08-23 16:14
 */
public class IntegerTest {
    public static void main(String[] args) {
        int i = 10000;
        Integer j = new Integer(10000);
        System.out.println(i == j);
        System.out.println(j.equals(i));
        final int iMax = Integer.MAX_VALUE;
        System.out.println(iMax);
        System.out.println(iMax + 1);
        System.out.println(iMax + 2);
        testLoop();
        test2();

        int num = 4;
        System.out.println("=============");
        System.out.println(num & 1);
    }

    private static void testLoop() {
        myfor :
        for (int i = 0; i < 20; i++) {
            System.out.println("i = " + i);
            if (i == 10) {
                break myfor;
            }
        }
    }

    private static void test2() {
        Set<Short> set = new HashSet<>();
        for (short i = 0; i < 5; i++) {
            set.add(i);
            set.remove(i - 1);
        }
        System.out.println(set.size());
    }
}
