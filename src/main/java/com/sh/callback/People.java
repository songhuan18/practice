package com.sh.callback;

public class People {
    private Printer printer;

    public People(Printer printer) {
        this.printer = printer;
    }

    /**
     * 同步回调
     * @param callback
     * @param text
     */
    public void goToPrintSyn(Callback callback, String text) {
        printer.printer(callback, text);
    }

    public void  goToPrintAsyn(Callback callback, String text) {
        new Thread(() -> printer.printer(callback, text)).start();
    }
}
