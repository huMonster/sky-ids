package com.xtt.log.spring.config.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description kafka初始化配置->指定分区
 * @Author Monster
 * @Date 2021/3/10 15:42
 * @Version 1.0
 */
@Configuration
public class KafkaInitialConfig {
    @Bean
    public void initialTopic(){
//        return new NewTopic("");
    }
}
