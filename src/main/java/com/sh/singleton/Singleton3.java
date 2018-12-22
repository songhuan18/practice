package com.sh.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getINSTANCE() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton3();
        }
        return instance;
    }
}
