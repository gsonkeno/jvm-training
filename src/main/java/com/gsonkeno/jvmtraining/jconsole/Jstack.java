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

    /**
     * 线程锁等待
     */
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"createLockThread");
        thread.start();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        System.out.println("a");
        //jconsole显示该线程处在 RUNNABLE状态
        createBusyThread();
        br.readLine();
        System.out.println("b");
        Object lock = new Object();
        //jconsole显示该线程处于WAITING状态
        createLockThread(lock);
    }
}
