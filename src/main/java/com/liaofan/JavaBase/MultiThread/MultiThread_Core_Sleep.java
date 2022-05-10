package com.liaofan.JavaBase.MultiThread;

import java.util.Date;

/**
 * 多线程的基础：sleep()
 */
public class MultiThread_Core_Sleep {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            System.out.println("调用当前时间：" + new Date());
            Thread.sleep(1000);   //线程休眠
        }
    }
}
