package com.liaofan.adminex.Study.ThreadUtilCore.priority_02;

/**
 * 线程优先级
 * .线程优先级会提示(int)调度路优先调度该线程,,但它仅是一个提示，
 * 调度器可以忽略它
 * :如果CPU比较忙.那么优先级高的线
 */
public class priority {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (; ; ) {
                System.out.println("-----> task1:" + count++);
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            for (; ; ) {
                System.out.println("-----> task2:" + count++);
            }
        };

        Thread t1 = new Thread(task1,"t1");
        Thread t2 = new Thread(task2,"t2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
