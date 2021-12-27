package com.sh.jvm;

/**
 * -XX:NewSize=5m  初始年轻代大小
 * -XX:MaxNewSize=5m   最大年轻代大小
 * -XX:InitialHeapSize=10m  初始堆大小
 * -XX:MaxHeapSize=10m   最大堆大小
 * -XX:SurvivorRatio=8  Eden和Survivor的比例，默认8:1:1
 * -XX:PretenureSizeThreshold=10m  大对象阈值，如果对象超过10M则直接进入老年代
 * -XX:+UseParNewGC  年轻代时候ParNew垃圾收集器
 * -XX:+UseConcMarkSweepGC  老年代使用CMS垃圾收集器
 * -XX:+PrintGCDetails   GC日志信息
 * -XX:+PrintGCTimeStamps
 * -Xloggc:gc.log
 * @author sh
 * @date 2021/11/24 9:11 上午
 */
public class JVMParamSettingDemo1 {
    public static void main(String[] args) throws InterruptedException {
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;


        byte[] arrays = new byte[2 * 1024 * 1024];
        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        System.out.println("执行完成===============");
    }
}
