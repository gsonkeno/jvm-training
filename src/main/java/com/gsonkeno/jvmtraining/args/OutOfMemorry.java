package com.gsonkeno.jvmtraining.args;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx10m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=OutOfMemory.dump
 */
public class OutOfMemorry {

    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        while (true){
            Byte[] bytes = new Byte[1024*64];
            list.add(bytes);
        }
    }
}
