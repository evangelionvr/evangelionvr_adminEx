package com.liaofan.adminex.ElasticSearchUtil;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;

import java.io.IOException;

public class ElasticSearchCore {
    public static void main(String[] args) {


        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));    // 创建客户端
        try {
            esClient.close();  // 关闭客户端
        } catch (IOException e) {
            e.printStackTrace();
        }

        variadicFunction("廖钒","范文静",
                "zhuYa");    // 可变函数

        variadicFunction_2("你好","廖钒","范文静","zhuYa");

    }

    /**
     * 可变函数
     */
    public static void variadicFunction(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    //面试

    /**
     * 可变函数_为什么限制可变参数只能砸最后
     *  为了避免歧义吗,只能有一个可变参数
     */
    public static void variadicFunction_2(String args_signle, String... args) {
        for (String arg : args) {
            System.out.print(args_signle + ":");
            System.out.println(arg);
        }
    }

}
