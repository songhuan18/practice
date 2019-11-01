package com.sh.design.adapter.objectadapter;

/**
 * @author sh
 * @date 2019-08-16 11:22
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dest = 0;
        if (null != voltage220V) {
            int output = voltage220V.output();
            dest = output / 44;
        }
        return dest;
    }
}
