package com.xoste.rabbitmqexchangefanoutconsumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * push服务接收者
 * @author Leon
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT),
        value = @Queue(value = "${rabbitmq.config.queue.push}")

))
public class PushReceiver {

    @RabbitHandler
    public void pushReceive(String msg) {
        System.out.println("push......receive:" + msg);
    }
}
