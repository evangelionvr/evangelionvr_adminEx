package com.liaofan.adminex.Study.ThreadUtilCore.Sync_03.join;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;


/**
 * 分析
 * ■因为主线程和线程t1是并行执行的。t1线程需要1秒之后才能算出| r=10
 * ■而主线程一开始就要打印r的结果,所以只能打印出
 * r=0
 *
 * 评价:
 *          ●-需要外部共享变量,不符合面向对象封装的思想
 *          ●-必须等待线程结束,不能配合线程池使用
 */
@Slf4j
public class Join {
    static int r = 0;

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        log.debug("开始");

        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        });

        t1.start();
        try {
            log.debug("t1线程的状态为:{}", t1.getState());
            t1.join();     //针对t1使用join后, 就需要等t1执行完成之后,才会继续执行其他线程
            log.debug("t1线程的状态为:{}", t1.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("结果为:{}", r);
        log.debug("结束");

        //获取线程的状态

    }
}
