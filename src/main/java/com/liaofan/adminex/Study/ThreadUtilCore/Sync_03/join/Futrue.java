package com.liaofan.adminex.Study.ThreadUtilCore.Sync_03.join;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

@Slf4j
public class Futrue {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        log.debug("开始");
        FutureTask<Integer> futrueTaskResult = new FutureTask<>(() -> {
            log.debug("凯撒");
            sleep(1);
            return 10;
        });

        new Thread(futrueTaskResult, "t1").start();
        try {
            log.debug("结果为:{}", futrueTaskResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
