package com.liaofan.JavaAdvanced.JUC;

import lombok.extern.slf4j.Slf4j;

/**
 * 从源码来区分Thread和Runnable
 * @author evangelion
 */
@Slf4j
public class Distinguish_Thread_Runable {
    public static void main(String[] args) {
        test_Runable();
    }

    /**
     * 测试Runable
     * 推荐,能够脱离继承
     */
    public static void test_Runable() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.info("r1");
            }
        };

        //实际上是调用了r1.run(),只是把r1包装成了Runnable
        Thread t1 = new Thread(r1);
        t1.start();
    }

    /**
     * 测试线程
     *
     */
    public static void test_Thread() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.debug("t1");
            }
        };

        t1.start();
    }
}
