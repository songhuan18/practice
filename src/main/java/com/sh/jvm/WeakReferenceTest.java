package com.sh.jvm;

import java.lang.ref.WeakReference;

/**
 * @author sh
 * @date 2020-02-19 16:39
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
//        String str = "hello word";
//        String str1 = str;
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println("============");
        System.out.println(o1);
        System.out.println(weakReference.get());
//        System.out.println(str1);
    }
}
