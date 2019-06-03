package com.sh.singleton;

public class TestSingletonEnum {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(EnumSingleton::getInstance).start();
        }
    }
}