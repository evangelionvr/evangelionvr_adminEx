package com.liaofan.adminex.ElasticSearchUtil;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class ElasticSearchCore_Serach {
    public static void main(String[] args) throws IOException {

            //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200)));

//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //2. 条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("sex","女")));
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //3.分页查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //(当前页码减一)*每页显示的条数
//        queryBuilder.from(2);
//        queryBuilder.size(2);
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //4.查询排序
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //(当前页码减一)*每页显示的条数
////        queryBuilder.from(2);
////        queryBuilder.size(2);
//        queryBuilder.sort("age", SortOrder.DESC);
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        // 5.过滤字段
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //(当前页码减一)*每页显示的条数
////        queryBuilder.from(2);
////        queryBuilder.size(2);
//        String[] excludes = {"age"};
//        String[] include={};
//        queryBuilder.fetchSource(include,excludes);
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }
//
        //6. 组合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","女"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","30"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","40"));
//
//        queryBuilder.query(boolQueryBuilder);
//
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //7..范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","女"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","40"));
//        rangeQueryBuilder.gt("30");
//        rangeQueryBuilder.lte("40");
//
//        queryBuilder.query(rangeQueryBuilder);
//
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //8.模糊查询

//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.TWO);
//
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","女"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","40"));
////        rangeQueryBuilder.gt("30");
////        rangeQueryBuilder.lte("40");
//
//        queryBuilder.query(fuzzyQueryBuilder);
//
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //9.高亮查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");
//
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex","女"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","30"));
////        boolQueryBuilder.should(QueryBuilders.matchQuery("age","40"));
////        rangeQueryBuilder.gt("30");
////        rangeQueryBuilder.lte("40");
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        queryBuilder.highlighter(highlightBuilder);
//        queryBuilder.query(termQueryBuilder);
//
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //10. 聚合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//
//
//        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        queryBuilder.aggregation(aggregationBuilder);
//
//        searchRequest.source(queryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits responseHits = searchResponse.getHits();
//
//        System.out.println(responseHits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        for(SearchHit searchHits : responseHits ) {
//            System.out.println(searchHits.getSourceAsString());
//
//        }

        //11.分组查询
        SearchRequest searchRequest = new SearchRequest(); //查询请求
        searchRequest.indices("user");    //指定索引


        SearchSourceBuilder queryBuilder = new SearchSourceBuilder();  //查询条件
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age"); //分组字段
        queryBuilder.aggregation(aggregationBuilder); //添加分组条件

        searchRequest.source(queryBuilder); //添加查询条件

        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT); //查询
        SearchHits responseHits = searchResponse.getHits(); //获取查询结果

        System.out.println(responseHits.getTotalHits());   //获取查询结果总数
        System.out.println(searchResponse.getTook());      //获取查询耗时

        for(SearchHit searchHits : responseHits ) {      //遍历查询结果
            System.out.println(searchHits.getSourceAsString());  //获取查询结果

        }



        try {
            esClient.close(); //关闭连接
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
