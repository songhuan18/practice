package com.sh.singleton;

/**
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部的加载和初始化而初始化，它是要单独去加载和初始化的
 */
public class Singleton5 {
    private Singleton5() {

    }

    private static class Inner {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Inner.INSTANCE;
    }
}
