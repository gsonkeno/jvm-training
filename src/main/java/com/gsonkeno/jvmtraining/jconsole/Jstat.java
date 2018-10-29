package com.gsonkeno.jvmtraining.jconsole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设置虚拟机参数为 -Xms100m -Xmx100m -XX:+UseSerialGC
 * -verbose:gc -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 默认情况下 新生代:老年代=1:2
 * 这段代码的意思是以64KB/1000ms的速度往java堆中填充数据，一共填充1000次
 */
public class Jstat {
    /**
     * 内存占位符对象，一个OOMObject大约占64 KB
     */
    static class OOMObject{
        private byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int nums) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
            System.out.println(new Date());
        }
        System.gc();
        System.out.println("invoked System.gc");
        Thread.sleep(10*1000);
        System.out.println(new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.out.println("jumped out fillHeap");
        Thread.sleep(10*1000);
        System.out.println(new Date());
    }
}
