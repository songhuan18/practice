package com.sh.callback;

public class TestCallback {
    public static void main(String[] args) {
        Printer printer = new Printer();
        People people = new People(printer);
        // 同步回调
//        people.goToPrintSyn(mes -> System.out.println(mes), "java.doc");
//        System.out.println("同步回调... 我在这儿等着你");
        // 异步回调
        people.goToPrintAsyn(mes -> System.out.println(mes), "java.doc");
        System.out.println("异步回调... 我有事等下通知我");
    }
}
