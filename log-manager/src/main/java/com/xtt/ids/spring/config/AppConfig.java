package com.xtt.ids.spring.config;

import com.xtt.lib.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description AppConfig
 * @Author Monster
 * @Date 2021/3/10 15:41
 * @Version 1.0
 */
@Configuration
//AOP
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class AppConfig {
    /**
     * 唯一id生成器
     */
    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker();
    }
}
