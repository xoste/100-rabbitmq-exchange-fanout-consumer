package com.xoste.rabbitmqexchangefanoutconsumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * sms短信接收者
 * @author Leon
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT),
        value = @Queue(value = "${rabbitmq.config.queue.sms}", autoDelete = "true")
))
public class SmsReceiver {

    @RabbitHandler
    public void smsReceive(String msg) {
        System.out.println("sms......receive:" + msg);
    }
}
