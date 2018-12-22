package com.sh.callback;

public class Printer {
    public void printer(Callback callback, String text) {
        System.out.println("正在打印...." + text);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.printFinished("打印完成");
    }
}
