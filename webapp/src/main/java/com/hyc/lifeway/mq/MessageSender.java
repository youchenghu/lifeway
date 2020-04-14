package com.hyc.lifeway.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ：胡友成
 * @Date ：2020/4/13 2:18 下午
 * @Description：
 */
@Component
public class MessageSender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("HelloQueue", msg);
    }

    public void send2(String msg) {
        this.amqpTemplate.convertAndSend("HighA", msg);
    }
}
