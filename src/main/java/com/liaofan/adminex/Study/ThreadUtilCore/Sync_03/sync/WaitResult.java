package com.liaofan.adminex.Study.ThreadUtilCore.Sync_03.sync;

import com.liaofan.adminex.Study.ThreadUtilCore.CommonThreadUtil;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class WaitResult {
    public static void main(String[] args) throws InterruptedException {
        test_timeliness();
    }

    private static int r1 = 0;
    private static int r2 = 0;

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        });

        //获取当前起始时间
        long start = System.currentTimeMillis();



        t1.start();
        CommonThreadUtil.getState(t1);
        t2.start();
        CommonThreadUtil.getState(t2);
        t1.join();
        CommonThreadUtil.getState(t1);
        CommonThreadUtil.getState(t2);
        t2.join();
        CommonThreadUtil.getState(t1);
        CommonThreadUtil.getState(t2);
        long end = System.currentTimeMillis();
        log.debug("r1:{} r2:{} cost {}", r1, r2, end - start);




    }

    /**
     * 有时效性的join
     */
    public static void test_timeliness() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        //获取当前起始时间
        long start = System.currentTimeMillis();
        System.out.println("start:" + start);
        t1.start();
        //线程执行结束会导致join结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        log.debug("r1:{} cost {}", r1, end - start);
    }


}
