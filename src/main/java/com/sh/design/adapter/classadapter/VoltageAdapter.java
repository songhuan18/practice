package com.sh.design.adapter.classadapter;

/**
 * @author sh
 * @date 2019-08-16 11:22
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int output = output();
        int dest = output / 44;
        return dest;
    }
}
