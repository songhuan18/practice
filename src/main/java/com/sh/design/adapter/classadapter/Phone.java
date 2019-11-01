package com.sh.design.adapter.classadapter;

/**
 * @author sh
 * @date 2019-08-16 11:23
 */
public class Phone {
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("适配之后，输出电压为5V");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("输出电压大于5V，无法充电");
        }
    }
}
