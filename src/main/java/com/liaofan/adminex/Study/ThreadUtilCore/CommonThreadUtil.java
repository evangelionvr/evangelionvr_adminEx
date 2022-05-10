package com.liaofan.adminex.Study.ThreadUtilCore;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonThreadUtil {
    public static void getState(Thread t) {
        System.out.println(t.getName() + "状态:" +t.getState());
    }

    //中断线程
    public static void interrupt(Thread t) {
        t.interrupt();
        System.out.println(t.getName() + "中断");
    }

    //恢复线程
    public static void resume(Thread t) {
        t.resume();
        System.out.println(t.getName() + "恢复");
    }
    //挂起线程
    public static void suspend(Thread t) {
        t.suspend();
        System.out.println(t.getName() + "挂起");
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //is.close();



    }








    //获取中文
    public static String getChinese(String str) {
        String regEx = "[^\u4e00-\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

  //字符串生成word文档
    public static String createWord(String fileName, String content) {
        try {
            String path = "Z:/" + fileName + ".doc";
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(content);
            osw.flush();
            return path;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //




}
