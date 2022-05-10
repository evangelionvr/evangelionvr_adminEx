package com.liaofan.JavaBase.MultiThread;

/**
 * 守护线程
 * 守护线程是指在主线程结束后，守护线程会自动结束。
 */
public class MultiThread_Core_DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println("守护线程开始执行");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i + ",是否为守护线程:" + Thread.currentThread().isDaemon());
        }
    }

    public static void main(String[] args) {
        MultiThread_Core_DaemonThread daemonThread = new MultiThread_Core_DaemonThread();
        daemonThread.setDaemon(true);   //设置守护线程
        daemonThread.start();   //启动守护线程


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i);   //主线程
        }

        //----程序执行到此处,前台线程就结束了----
        //----守护线程也结束了----
    }
}
