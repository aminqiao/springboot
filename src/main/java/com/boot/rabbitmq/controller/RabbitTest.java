package com.boot.rabbitmq.controller;

import com.boot.rabbitmq.sender.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private PersonSender personSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    /**
     * 一个生产者，一个消费者
     */
    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send("hello_oneToOne");
    }

    /**
     * 单生产者-多消费者
     */
    @RequestMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hello_onoToMany:" + i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @RequestMapping("/manyToMany")
    public void manyToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomsg:" + i);
            helloSender2.send("hellomsg:" + i);
        }
    }

    /**
     * 实体类传输测试
     */
    @RequestMapping("/personTest")
    public void personTest() {
        personSender.send();
    }

    /**
     * topic exchange类型测试
     */
    @RequestMapping("/topmessage")
    public void topicTest() {
        topicSender.send();
    }
    /**
     * fanout exchange类型测试
     */
    @RequestMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }
}
