package com.boot.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        //即使指定了routing_key为"abcd.ee"，但是所有接收者都接受到了消息
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }
}
