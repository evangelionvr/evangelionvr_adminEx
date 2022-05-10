package com.liaofan.adminex.ElasticSearchUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * 修改数据
 */
public class ES_Doc_Update {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));

        UpdateRequest updateIndexRequest = new UpdateRequest();  //创建修改请求
        updateIndexRequest.index("user").id("1001");       //设置索引和id
        updateIndexRequest.doc(XContentType.JSON,"sex","女");

        UpdateResponse updateResponse = esClient.update(updateIndexRequest, RequestOptions.DEFAULT);  //
        System.out.println(updateResponse.getResult());

//        updateIndex.index("user").id("1001");
//        User user = new User();
//        user.setAge(30);
//        user.setName("廖钒");
//        user.setSex("男");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String userJson = objectMapper.writeValueAsString(user);
//        updateIndex.source(userJson, XContentType.JSON);
//        IndexResponse response = esClient.update(updateIndex, RequestOptions.DEFAULT);
//        System.out.println(response.getResult());

        try {
            esClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
