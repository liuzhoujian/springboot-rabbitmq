package com.lzjrabbitmq;

import com.lzjrabbitmq.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchangeAndQueue() {
        //依次创建exchange\queue\binding
        //构建exchange
        //amqpAdmin.declareExchange(new DirectExchange("test.direct"));

        //构建queue
        //amqpAdmin.declareQueue(new Queue("test.queue", true));

        //构建绑定规则
        amqpAdmin.declareBinding(new Binding("test.queue", Binding.DestinationType.QUEUE,"test.direct" , "test.lzj", null));
    }



    /**
     * 单播-点对点
     */
    @Test
    public void contextLoads() {
        //exchange  routingKey object(自己的消息体)
        //发送消息,默认使用JDK的序列化机制，如何转为JSON？配置自己的MessageConverter
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news",
                new User("张三", 18));
    }


    //从queue中取出数据，以JSON格式
    @Test
    public void receive() {
        User user = (User) rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(user);
    }


    //广播
    @Test
    public void test1() {
        rabbitTemplate.convertAndSend("exchange.fanout", "",
                new User("张三", 18));
    }
}

