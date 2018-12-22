package com.sh.singleton;

/**
 * 饿汉式：
 * （1）构造函数私有化
 * （2）自行创建，并且用静态变量保存
 * （3）向外提供实例
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }
}
