package com.xtt.ids.config.security;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.xtt.lib.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description AppConfig
 * @Author Monster
 * @Date 2021/3/16 10:41
 * @Version 1.0
 */
@Slf4j
@Configuration

// 开启数据库事务
//@EnableTransactionManagement
// mybatis扫描
//@MapperScan("com.xtt.ids.web.**.persistence")

// 开启feign
@EnableFeignClients(basePackages = "com.xtt.ids.web.**.service")
// AOP
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class AppConfig {

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker();
    }

    /**
     * Jackson全局转化long类型为String，解决jackson序列化时long类型缺失精度问题
     *
     * @return Jackson2ObjectMapperBuilderCustomizer 注入的对象
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Jackson2ObjectMapperBuilderCustomizer cunstomizer = new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.serializerByType(BigInteger.class, ToStringSerializer.instance);
                //Long
                jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance);
                //long
//                jacksonObjectMapperBuilder.serializerByType(Long.TYPE, ToStringSerializer.instance);
            }
        };
        return cunstomizer;
    }

    /**
     * 线程池配置
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor restExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(8);
        taskExecutor.setMaxPoolSize(16);
        taskExecutor.setKeepAliveSeconds(30);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);
        factory.setTaskExecutor(restExecutor());
        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }
}
