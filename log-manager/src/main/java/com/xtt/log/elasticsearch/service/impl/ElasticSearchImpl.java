package com.xtt.log.elasticsearch.service.impl;

import com.xtt.log.elasticsearch.service.ElasticSearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.indices.ClearCache;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Description ElasticSearchImpl
 * @Author Monster
 * @Date 2021/3/18 11:05
 * @Version 1.0
 */
@Service
public class ElasticSearchImpl implements ElasticSearchService {

    private Logger log = LoggerFactory.getLogger(ElasticSearchImpl.class);

    @Autowired
    private JestClient jestClient;

    @Override
    public JestResult createIndex(String indexName) {
        CreateIndex createIndex = new CreateIndex.Builder(indexName).build();
        JestResult result = null;
        try {
            result = jestClient.execute(createIndex);
            if (result == null || !result.isSucceeded()) {
                throw new Exception(result.getErrorMessage() + "创建索引失败");
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return result;
    }

    @Override
    public JestResult deleteIndex(String type) {
        DeleteIndex deleteIndex = new DeleteIndex.Builder(type).build();
        JestResult result = null;
        try {
            result = jestClient.execute(deleteIndex);
            log.info("deleteIndex == " + result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JestResult clearCache() {
        ClearCache clearCache = new ClearCache.Builder().build();
        JestResult result = null;
        try {
            result = jestClient.execute(clearCache);
            log.info("clearCache == " + result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
