package com.gsonkeno.jvmtraining.jconsole;

/**
 * 死锁
 * @author gaosong
 * @since 2018-10-30
 */
public class DeadLock {
    static class  SynAddRunnable implements Runnable{
        int a,b;
        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        //会发生死锁，jconsole的线程菜单面板中子菜单“死锁”可以显示相关情况
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1,2),"first_"+ i).start();
            new Thread(new SynAddRunnable(2,1),"second_" + i).start();
        }

//        名称: first_4
//        状态: java.lang.Integer@4ac660dc上的BLOCKED, 拥有者: second_3
//        总阻止数: 2, 总等待数: 0
//
//        堆栈跟踪:
//        com.gsonkeno.jvmtraining.jconsole.DeadLock$SynAddRunnable.run(DeadLock.java:20)
//        - 已锁定 java.lang.Integer@2f241f54
//        java.lang.Thread.run(Thread.java:745)
//
//         ==============================================================================
//        名称: second_3
//        状态: java.lang.Integer@2f241f54上的BLOCKED, 拥有者: first_4
//        总阻止数: 2, 总等待数: 0
//
//        堆栈跟踪:
//        com.gsonkeno.jvmtraining.jconsole.DeadLock$SynAddRunnable.run(DeadLock.java:20)
//        - 已锁定 java.lang.Integer@4ac660dc
//        java.lang.Thread.run(Thread.java:745)
    }
}
