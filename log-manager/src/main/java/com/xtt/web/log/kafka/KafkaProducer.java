package com.xtt.web.log.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @Description KafkaProducer
 * @Author Monster
 * @Date 2021/3/10 15:42
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送消息到Kafka
     *
     * @param topic 主题
     * @param message 消息体
     */
    public void sendMessage(String topic, String message){
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
        send.addCallback(result -> {}, ex -> log.info("发送失败：" + message));
    }


}
