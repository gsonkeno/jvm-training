package com.gsonkeno.jvmtraining.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置虚拟机参数为 -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class Jconsole {
    /**
     * 内存占位符对象，一个OOMObject大约占64 KB
     */
    static class OOMObject{
        private byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int nums) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
        Thread.sleep(1*1000);
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
