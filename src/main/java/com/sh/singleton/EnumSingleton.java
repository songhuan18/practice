package com.sh.singleton;

/**
 * 枚举单例
 */
public class EnumSingleton {

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
            return enumSingleton;
        }
    }
}
