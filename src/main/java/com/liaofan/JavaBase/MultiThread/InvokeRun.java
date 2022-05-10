package com.liaofan.JavaBase.MultiThread;


/**
 * @author liaofan
 * 直接调用run方法
 */
public class InvokeRun extends Thread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //System.out.println(Thread.currentThread().getName() + " " + i);

            if (i == 20) {
                new InvokeRun().run();    //直接调用run方法,是直接在主线程中执行的
                new InvokeRun().start();  //调用start方法,是在新线程中执行的
            }
        }
    }

    @Override
    public void run() {
        System.out.println("InvokeRun run");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
