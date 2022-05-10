package com.liaofan.adminex.Study.ThreadUtilCore.Sync_03.interruput;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;



@Slf4j
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        interruputPark();
    }

    public static void test_Interrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        //t1.join();
        Thread.sleep(1);
        t1.interrupt();
        log.debug("打断状态:{}", t1.isInterrupted());
    }

    /**
     * 测试中断的正常线程
     * @throws InterruptedException
     */
    public static void test_InterruptNormalThread() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();   //获取当前线程
                boolean interrupted = currentThread.isInterrupted(); //获取当前线程是否被中断

                if (interrupted) {  //如果被中断
                    log.debug("打断状态:{}", interrupted); //打印中断状态
                    break;   //退出循环
                }
            }
        },"t2");

        t2.start(); // 启动线程
        Thread.sleep(1); // 睡眠1秒
        t2.interrupt(); // 打断线程
    }

    /**
     * 测试中断的阻塞线程
     * @throws InterruptedException
     */
    public static void interruputPark() throws InterruptedException {
        Thread t3 = new Thread(() -> {
            log.debug("park....");
            LockSupport.park();
            log.debug("unpark....");
            log.debug("t3.isInterrupted:{}", Thread.currentThread().isInterrupted());
        }, "t3");


        t3.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.interrupt();
        //t3.join();
        log.debug("线程状态_start:" + t3.getState());
        Thread.sleep(1);

    }



}
