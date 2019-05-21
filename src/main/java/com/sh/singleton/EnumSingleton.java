package com.sh.singleton;

/**
 * 枚举单例
 */
public class EnumSingleton {

    private EnumSingleton() {
        System.out.println(Thread.currentThread().getName() + " 我是构造方法");
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getEnumSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private EnumSingleton enumSingleton;

        Singleton() {
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getEnumSingleton() {
            System.out.println("调用了");
            return enumSingleton;
        }
    }
}
