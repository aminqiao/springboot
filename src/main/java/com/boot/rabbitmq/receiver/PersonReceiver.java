package com.boot.rabbitmq.receiver;

import com.boot.domain.Person;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "user")
public class PersonReceiver {
    @RabbitHandler
    public void process(Person person) {
        System.out.println(person.getName()+":"+person.getAge());
    }
}
