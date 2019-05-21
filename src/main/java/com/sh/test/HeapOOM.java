package com.sh.test;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        // 设置虚拟机参数
        // -Xms20m堆的最小值，-Xmx20m堆的最大值
        /**
         * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
         */
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
