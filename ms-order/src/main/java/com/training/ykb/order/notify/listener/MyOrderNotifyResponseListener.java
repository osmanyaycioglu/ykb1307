package com.training.ykb.order.notify.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.training.ykb.notify.models.NotifyResponse;

@Component
public class MyOrderNotifyResponseListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_response_q", durable = "true"),
                                             exchange = @Exchange(name = "notify_response_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_response"))
    public void handle1(final NotifyResponse str) {
        System.out.println("Response from notify ms : " + str);
    }


}
