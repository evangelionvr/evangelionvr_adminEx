package com.liaofan.adminex.ElasticSearchUtil;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class ES_Index_Create {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));

        //创建索引
        CreateIndexRequest request_create = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request_create, RequestOptions.DEFAULT);

        //相应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作：" + acknowledged);




        try {
            esClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
