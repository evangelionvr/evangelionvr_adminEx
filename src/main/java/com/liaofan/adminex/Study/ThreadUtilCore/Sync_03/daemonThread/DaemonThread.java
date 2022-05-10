package com.liaofan.adminex.ThreadUtilCore.Sync_03.daemonThread;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author liaofan
 * 守护线程
 * 注意:
 * 垃圾回收器线程就是一种守护线程
 * "Tonmcat 中的Aceer和Plerl线程都是守护线程,所以Tomcat 接收到shutdom命令后,不会等
 * 待它们处理完当前请求
 */
@Slf4j
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        test_DaemonThread();
    }

    public static void test_DaemonThread() throws InterruptedException {
        log.debug("开始创建守护线程");
        Thread thread = new Thread(() ->{
            log.debug("守护线程开始执行");
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"daemonThread");

        thread.setDaemon(true);
        thread.start();

        //获取线程的状态  守护线程
        log.debug("线程状态: {}",thread.getState());

        sleep(1);
        log.debug("主线程结束");

    }
}
