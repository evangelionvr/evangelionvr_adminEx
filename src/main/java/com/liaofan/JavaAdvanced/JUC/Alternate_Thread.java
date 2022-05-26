package com.liaofan.JavaAdvanced.JUC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Alternate_Thread {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
               log.debug("running");
            }
        },"t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("running");
            }
        },"t2").start();
    }
}
