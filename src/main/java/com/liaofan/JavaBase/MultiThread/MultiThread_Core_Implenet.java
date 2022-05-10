package com.liaofan.JavaBase.MultiThread;


/**
 * 实现Runnable接口创建线程类
 */

/**
 * 1.定义实现Runnable接口的实现类,并重写run方法
 */
public class MultiThread_Core_Implenet implements Runnable {

    private final String threadName;


    public MultiThread_Core_Implenet(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 2.重写run方法,该方法是线程执行的执行体
     */
    @Override
    public void run() {
        System.out.println(threadName + ":" + "MultiThread_Core_Implenet run");
    }

    public static void main(String[] args) {
        //3.创建该Runable实现类的实例,Runnable 象仅仅作 Thread 对象的 target,Runnable 实现类里包含的 runO 方法仅 •作为线程执行休 而实际的线程对象依然是 Thread 实例，只是该 Thread 线程负责执行其 target runO 方法
        MultiThread_Core_Implenet multiThread_core_implenet1 = new MultiThread_Core_Implenet("线程1");   // 创建线程对象
        //4.并以此实例作为参数创建线程
        Thread thread1 = new Thread(multiThread_core_implenet1,"线程1_+V=-QM-2_Vg=.......09-=-");   // 创建线程

        MultiThread_Core_Implenet multiThread_core_implenet2 = new MultiThread_Core_Implenet("线程2");   // 创建线程对象
        Thread thread2 = new Thread(multiThread_core_implenet2,"线程2_+V=-QMe-1_Vg...1_M_QsMvc");   // 创建线程


        thread2.setPriority(Thread.MAX_PRIORITY);   // 设置线程优先级

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

        //5.启动线程
        thread1.start();
        //5.启动线程
        thread2.start();
    }
}
