package com.liaofan.JavaAdvanced.JUC;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 对于FutureTask的使用
 * 它是对Runable的封装，可以设置返回值，可以设置异常
 * 可以获取任务的结果
 */
@Slf4j(topic = "c.FutureTaskTest")
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                log.info("call");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t = new Thread(task,"t1");
        t.start();

        log.debug("task.get():{}",task.get());

    }
}
