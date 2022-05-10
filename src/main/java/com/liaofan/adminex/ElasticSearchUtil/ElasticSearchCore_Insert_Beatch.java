package com.liaofan.adminex.ElasticSearchUtil;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ElasticSearchCore_Insert_Beatch {
    public static void main(String[] args) throws IOException {

            //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));

        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest source_zhangSan = new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan","age","30","sex","男");
        IndexRequest source_Lisi = new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "LiSi","age","30","sex","男");
        IndexRequest source_WangWu = new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu","age","40","sex","女");
        IndexRequest source_WangWu1 = new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu1" ,"age","50","sex","男");
        IndexRequest source_WangWu2 = new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu2","age","60","sex","女");
        IndexRequest source_WangWu3 = new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu3","age","70","sex","男");

        bulkRequest.add(source_zhangSan,source_Lisi,source_WangWu,source_WangWu1,source_WangWu2,source_WangWu3);

        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());
        try {
            esClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
