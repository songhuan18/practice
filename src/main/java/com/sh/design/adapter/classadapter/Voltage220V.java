package com.sh.design.adapter.classadapter;

/**
 * @author sh
 * @date 2019-08-16 11:20
 */
public class Voltage220V {
    public int output() {
        int src = 220;
        System.out.println("当前输出电压为220V");
        return src;
    }
}
