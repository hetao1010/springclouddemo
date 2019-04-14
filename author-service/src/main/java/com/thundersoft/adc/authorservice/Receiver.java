package com.thundersoft.adc.authorservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.thundersoft.adc.authorservice.person.model.PersonDO;
import com.thundersoft.adc.authorservice.person.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 监听的业务类，实现接口MessageListener
 * Created by hetao on 2019/4/1.
 */

@RabbitListener(containerFactory = "rabbitListenerContainer", queues = AmqpConfig.QUEUE_NAME_FAIL)
public class Receiver implements ChannelAwareMessageListener {
    public Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PersonService personService;

    @Autowired
    private RabbitTemplate template;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        try {

            logger.info("##### = {}", new String(message.getBody()));

            ObjectMapper objectMapper = new ObjectMapper();
            PersonDO personDO = objectMapper.readValue(new String(message.getBody()), PersonDO.class);
            //模拟耗时操作
//            TimeUnit.SECONDS.sleep(1);
            boolean result = personService.addPerson(personDO);
            logger.info("接受到消息：" + personDO.toString());
            if (!result) {
                logger.error("消息消费失败");
            } else {
                logger.info("消息消费成功");
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//手动消息应答
        } catch (Exception e) {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//手动消息应答
            logger.error(e.getMessage(), e);
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);//true 重新放入队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);//对于处理不了的异常消息
            ObjectMapper objectMapper = new ObjectMapper();
            PersonDO personDO = objectMapper.readValue(new String(message.getBody()), PersonDO.class);
            //发送到失败队列
            template.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.ROUTINGKEY_FAIL, personDO);
        }
    }


}
