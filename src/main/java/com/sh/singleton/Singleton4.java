package com.sh.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class Singleton4 {

    private static volatile Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getINSTANCE() {
        if (instance == null) {
            synchronized(Singleton4.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
