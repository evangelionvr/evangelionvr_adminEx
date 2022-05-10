package com.liaofan.JavaBase.MultiThread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThread_Core_CallableFuture {

    public void sec() {
        MultiThread_Core_CallableFuture task = new MultiThread_Core_CallableFuture();
        Callable<Integer> callable = () -> {
            int i = 0;
            for (; i < 100; i++) {
                i++;
                System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);
            }

            return i;
        };

        Callable callable_Obj = new Callable() {
            @Override
            public Object call() throws Exception {
                int i = 0;
                for (; i < 100; i++) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);
                }

                return i;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable_Obj);
        Thread thread = new Thread(futureTask, "有返回值的线程");
        thread.start();
    }

    public static void main(String[] args) {
        //创建一个Callable对象
        MultiThread_Core_CallableFuture task = new MultiThread_Core_CallableFuture();
        //先使用lamda表达式创建一个Callable对象
        //使用FutureTask类来包装Callable对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                i++;
                System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);
            }

            return i;

        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);

            if (i == 20) {
                new Thread(futureTask, "有返回值的线程").start();
            }

            try {
                System.out.println("子线程的返回值:" + futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}
