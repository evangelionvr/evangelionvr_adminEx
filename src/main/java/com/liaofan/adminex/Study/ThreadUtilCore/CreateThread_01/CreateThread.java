package com.liaofan.adminex.Study.ThreadUtilCore.CreateThread_01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 线程的创建
 * <p>
 * /**
 * * 分析Thread的源码,理清它与Runnable的关系
 * * 小结
 * * ●方法1是把线程和任务合并在了-起,方法2是把线程和任务分开了
 * * ●用Runnable更容易与线程池等高级API配合
 * * ●用Runnable让任务类脱离了Thread继承体系,更灵活
 * *
 */
@Slf4j
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 构造方法中的是:线程名称
         */
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                log.debug("线程启动");
            }
        };

        thread.start();

        /**
         * 方法二，使用 Runnable 配合 Thread
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("使用 Runnable 配合 Thread");
            }
        };

        Thread t = new Thread(runnable, "t1");
        t.start();

        /**
         * 方法三  Java 8以后可以使用lambda精简代码
         */
        Runnable taskRunnable_2 = () -> log.debug("Java 8以后可以使用lambda精简代码");
        Thread thread_taskRunnable_2 = new Thread(taskRunnable_2);
        thread_taskRunnable_2.start();

        /**
         * 方法4   方法三，FutureTask 配合 Thread
         * FutureTask 能够接收 Callable 类型的参数，用来处理有返回结果的情况
         */
        FutureTask<Integer> task_futrue = new FutureTask<Integer>(() -> {
            log.debug("task");
            return 1000;
        });

        new Thread(task_futrue,"t3").start();
        Integer result = task_futrue.get();
        log.debug("结果是:{}",result);


        //调用run
        Thread t_run = new Thread("t1") {
            @Override
            public void run() {
                log.debug("当前线程:" + Thread.currentThread().getName());
            }
        };
        //t_run.run();
        t_run.start();
        log.debug("do other thing");
    }
}
