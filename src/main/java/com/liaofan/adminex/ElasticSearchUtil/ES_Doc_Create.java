package com.liaofan.adminex.ElasticSearchUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ES_Doc_Create {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));   //连接ES服务器

        IndexRequest request = new IndexRequest();    //创建索引请求
        request.index("user").id("1001");    //索引名称和索引ID
        User user = new User();        //创建User对象
        user.setAge(30);    //设置User对象的属性
        user.setName("廖钒");  //设置User对象的属性
        user.setSex("男");   //设置User对象的属性

        ObjectMapper objectMapper = new ObjectMapper();    //创建ObjectMapper对象
        String userJson = objectMapper.writeValueAsString(user);  //将User对象转换为JSON字符串
        request.source(userJson, XContentType.JSON);      //设置索引请求的源数据
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT); //发送索引请求
        System.out.println(response.getResult());  //打印索引请求的结果

        try {
            esClient.close();   //关闭连接
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
