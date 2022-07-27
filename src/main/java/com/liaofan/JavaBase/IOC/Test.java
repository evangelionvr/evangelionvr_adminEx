package com.liaofan.JavaBase.IOC;

/**
 * @author 廖钒
 * @ClassName Test
 * @description: TODO
 * @datetime 2022年 07月 18日 13:31
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        DataConfig dataConfig = new DataConfig();
        dataConfig.setUrl("localhost:3306/localhost/dbname");
        dataConfig.setUsername("root");
        dataConfig.setPassword("root");
    }
}
