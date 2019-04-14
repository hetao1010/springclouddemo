package com.thundersoft.adc.trainserver.controller;

import com.thundersoft.adc.trainserver.AmqpConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzlbo on 2016/7/2.
 */
@RestController
@Api("MQ相关的api")
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "rabbitmq消息生产者")
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String testSend() {
        for (int i = 0;i < 100; i++) {
            Message message = MessageBuilder.withBody(
                    ("{\"id\":\"123456" + i +
                            "\",\"userId\":\"hetao" + i +
                            "\",\"userName\":\"何涛" + i+
                            "\",\"age\":26\r\n}").getBytes()).setMessageId("123"+i).build();
            rabbitTemplate.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.ROUTINGKEY, message);
        }
        return "ok";
    }
}
