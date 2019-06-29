package com.sh;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试内存溢出和内存泄露
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {
        leak();
    }

    /**
     * 测试内存泄露
     */
    private static void leak() {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}
