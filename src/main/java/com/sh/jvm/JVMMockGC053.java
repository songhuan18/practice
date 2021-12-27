package com.sh.jvm;

/**
 * 对应儒猿技术窝053章节
 * 地址：https://apppukyptrl1086.pc.xiaoe-tech.com/detail/i_5d11e734baf79_aQLEjh7D/1?from=p_5d0ef9900e896_MyDfcJi8&type=6
 * -XX:NewSize=100m -XX:MaxNewSize=100m
 * -XX:InitialHeapSize=200m -XX:MaxHeapSize200m
 * -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3m
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * @author sh
 * @date 2021/12/14 9:57 上午
 */
public class JVMMockGC053 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadDate();
        }
    }

    private static void loadDate() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
