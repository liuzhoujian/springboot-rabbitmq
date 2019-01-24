package com.lzjrabbitmq.service;

import com.lzjrabbitmq.bean.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(User user) {
        System.out.println(user);
    }

    @RabbitListener(queues = "atguigu.news")
    public void receiveMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
