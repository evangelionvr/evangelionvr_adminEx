package com.liaofan.JavaBase.MultiThread;


/**
 * 线程的启动和终止
 * 主要是讲线程的生命周期
 */
public class MultiThread_Core_StartOrDead extends Thread {
    private int i;

    public static void main(String[] args) {
        // 创建线程对象
        MultiThread_Core_StartOrDead sd = new MultiThread_Core_StartOrDead();
        // 循环创建300个线程
        for (int i = 0; i < 300; i++) {
            // 输出当前线程名称
            System.out.println(Thread.currentThread().getName() + " " + i);
                // 当i=20时，创建一个新的线程
            if (i == 20) {
                //启动线程
                sd.start();
                // 输出线程是否存活
                System.out.println(sd.isAlive());
            }

            //当线程处于新建和死亡两种状态时,isAlive()方法返回false
            //当i>20时,该线程已经启动,如果isALive()方法返回true,则说明线程还在运行,否则说明线程已经终止
            // 当i>20时，并且线程不存活时，创建一个新的线程
            if (i > 20 && !sd.isAlive()) {
                // 启动线程
                sd.start();
            }
        }
    }

    @Override
    public void run() {
        // 循环打印
        for (i = 0; i < 100; i++) {
            System.out.println(getName() + i);
        }
    }
}
