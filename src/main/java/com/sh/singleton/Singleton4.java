package com.sh.singleton;

/**
 * 懒汉式
 * 双重校验锁
 */
public class Singleton4 {

    private static volatile Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getINSTANCE() {
        if (instance == null) {
            synchronized(Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
