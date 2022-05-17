package com.liaofan.JavaAdvanced.JUC;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 异步方法
 * 多线程是java唯一可以实现异步的方式
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")   // 不提示
@Slf4j   // 日志
public class ASync {
    public static void main(String[] args) {
        new Thread(() -> {
            FileReader fr = null;

            try {
                System.out.println("开始读取文件" + System.currentTimeMillis() + ",线程名:" + Thread.currentThread().getName());
                fr = new FileReader("F:\\CloudMusic\\梁静茹 - 呵护.mp3");
                char[] buf = new char[1024];
                int len = 0;
                while ((len = fr.read(buf)) != -1) {
                    //System.out.println(new String(buf, 0, len));
                }
                System.out.println("读取mp3文件结束" + System.currentTimeMillis() + ",线程名:" + Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
        log.debug("main thread end" + ",线程名:" + Thread.currentThread().getName());
        // 创建一个线程对象
    }
}
