package com.boot.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    //验证direct队列
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user");
    }

    //验证topic队列

    /**
     * topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
     首先对topic规则配置，这里使用两个队列来测试，
     其中topic.message的bindting_key为“topic.message”，topic.messages的binding_key为“topic.#”
     * @return
     */
    @Bean(name = "message")
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean(name = "messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    /**
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息
     * @return
     */
    @Bean(name = "amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean(name = "bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean(name = "cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

}
