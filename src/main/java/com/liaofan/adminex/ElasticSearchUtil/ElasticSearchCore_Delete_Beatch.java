package com.liaofan.adminex.ElasticSearchUtil;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ElasticSearchCore_Delete_Beatch {
    public static void main(String[] args) throws IOException {

            //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));

        BulkRequest bulkRequest = new BulkRequest();    //创建批量请求
        DeleteRequest source_zhangSan = new DeleteRequest().index("user").id("1001");   //创建删除请求
        DeleteRequest source_Lisi = new DeleteRequest().index("user").id("1002");   //创建删除请求
        DeleteRequest source_WangWu = new DeleteRequest().index("user").id("1003");   //创建删除请求
        bulkRequest.add(source_zhangSan,source_Lisi,source_WangWu);  //添加到批量请求中

        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);  //批量请求
        System.out.println(response.getTook());  //打印批量请求耗时
        System.out.println(response.getItems());  //打印批量请求结果


        try {
            esClient.close();   //关闭客户端
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
