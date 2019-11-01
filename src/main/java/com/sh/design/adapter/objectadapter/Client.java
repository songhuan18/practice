package com.sh.design.adapter.objectadapter;

/**
 * @author sh
 * @date 2019-08-16 11:26
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Voltage220V voltage220V = new Voltage220V();
        phone.charging(new VoltageAdapter(voltage220V));
    }
}
