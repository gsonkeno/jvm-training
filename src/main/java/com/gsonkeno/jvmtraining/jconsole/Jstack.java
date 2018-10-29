package com.gsonkeno.jvmtraining.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jstack {

    /**
     * 线程死循环
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        },"createBusyThread");
        thread.start();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        System.out.println("a");
        createBusyThread();
    }
}
