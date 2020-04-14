package com.hyc.lifeway.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ：胡友成
 * @Date ：2020/4/13 2:18 下午
 * @Description：
 */
//@Component
//@RabbitListener(queues = "HighA")
public class MessageReceiver {

//    @RabbitHandler
    public void process(String msg) {
        System.out.println(msg);
    }
}
