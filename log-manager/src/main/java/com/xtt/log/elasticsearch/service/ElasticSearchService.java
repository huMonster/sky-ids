package com.xtt.log.elasticsearch.service;

import io.searchbox.client.JestResult;

/**
 * @Description ElasticSearchService
 * @Author Monster
 * @Date 2021/3/18 10:37
 * @Version 1.0
 */
public interface ElasticSearchService {

    /**
     * 创建索引（相当于创建数据库）
     * @param indexName
     * @return
     */
    public JestResult createIndex(String indexName);

    /**
     * 删除索引
     * @param type ：当前删除document名称
     */
    public JestResult deleteIndex(String type);

    // 清除缓存
    public JestResult clearCache();
}
