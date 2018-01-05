package com.boot.rabbitmq.sender;

import com.boot.domain.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PersonSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        Person person=new Person();
        person.setName("wuzm");
        person.setAge(26);
        this.rabbitTemplate.convertAndSend("user", person);
    }
}
