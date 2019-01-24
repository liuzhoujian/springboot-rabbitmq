package com.lzjrabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**rabbitmq自动配置RabbitAutoConfiguration:配置连接工厂、rabbitTemplate、AmqpAdmin
 *
 * 1、rabbitmq环境搭建
 * 2、登录rabbitmq管理界面（账号和密码都是guest）,创建exchange\queue，将exchange和queue进行绑定
 * 3、编写测试单元：注入rabbitTemplate,单播-广播测试、接受queue中的消息；编写MessageConver配置序列化方式为JSON
 * 4、编写监听方法，监听队列中的信息 @EnableRabbit+@RabbitListener
 * 5、AmqpAdmin：创建删除、exchange\queue、和绑定规则
 */

@EnableRabbit //开启rabbitmq注解
@SpringBootApplication
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }

}

