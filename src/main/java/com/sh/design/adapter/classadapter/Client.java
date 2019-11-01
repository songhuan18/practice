package com.sh.design.adapter.classadapter;

/**
 * @author sh
 * @date 2019-08-16 11:26
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
