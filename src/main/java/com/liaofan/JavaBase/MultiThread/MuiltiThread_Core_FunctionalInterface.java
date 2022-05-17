package com.liaofan.JavaBase.MultiThread;

public class MuiltiThread_Core_FunctionalInterface {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello World:" + Thread.currentThread().getName());
        Thread thread = new Thread(runnable );
        thread.start();
    }
}
