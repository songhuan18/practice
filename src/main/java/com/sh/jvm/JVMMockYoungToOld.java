package com.sh.jvm;

/**
 * 模拟对象从年轻代进入老年代
 * @author sh
 * @date 2021/11/29 9:21 上午
 */
public class JVMMockYoungToOld {
    public static void main(String[] args) {
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
//        array1 = null;
        byte[] array2 = new byte[128 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        System.out.println("=========");
    }
}
