package com.liaofan.JavaAdvanced.JUC;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;


/**
 * 同步方法
 */
@Slf4j
public class Sync {
    public static void main(String[] args) {
        //读取mp3文件
        FileReader fr = null;
        try {
            System.out.println("开始读取mp3文件" + System.currentTimeMillis());
            fr = new FileReader("F:\\CloudMusic\\梁静茹 - 呵护.mp3");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                //System.out.println(new String(buf, 0, len));
            }
            System.out.println("读取mp3文件结束" + System.currentTimeMillis());
        } catch (Exception e) {
            log.error("读取文件失败", e);
        }


        log.debug("end");
    }
}
