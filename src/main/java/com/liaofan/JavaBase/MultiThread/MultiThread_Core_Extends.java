package com.liaofan.JavaBase.MultiThread;


/**
 * Java多线程编程核心知识
 *
 * @author liaofan
 * @date 2018年12月18日
 * 线程是进程的组成部分，进程是操作系统的组成部分，操作系统是计算机系统的组成部分。
 *
 */

//1.继承Thread类
public class MultiThread_Core_Extends extends Thread {

    private final String threadName;
    public MultiThread_Core_Extends(String threadName) {
        this.threadName = threadName;
    }

    public int i;

    /**
     * 2.重写run方法
     */
    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(threadName + "_" + "中的i=" + i + "，当前线程名称：" + Thread.currentThread().getName());
            //System.out.println(Thread.currentThread().getName());   //获取当前线程名称
        }
    }

    public static void main(String[] args) {
        /**
         * 3.创建线程对象
         */
        MultiThread_Core_Extends t1 = new MultiThread_Core_Extends("线程1");

        t1.start();

        MultiThread_Core_Extends t2 = new MultiThread_Core_Extends("线程2");
        //设置优先级
        t2.setPriority(Thread.MAX_PRIORITY);
        //设置守护线程+守护线程会在主线程结束后自动结束,那是不是说明主线程结束后，守护线程也会结束？
        t2.setDaemon(true);

        //获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        //4.启动线程
        t2.start();
    }

}
