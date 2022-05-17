package com.liaofan.JavaAdvanced.JUC;

public class Lamda {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        Thread t = new Thread(r);
        t.start();


    }
}
