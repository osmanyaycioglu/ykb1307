package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_request_q_1", durable = "true"),
                                             exchange = @Exchange(name = "notify_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_key_1"))
    @SendTo("notify_response_exchange/notify_response")
    public NotifyResponse handle1(final NotifyRequest str) {
        System.out.println("Handle 1 : " + str);
        return new NotifyResponse(str.getOrderId(),
                                  1);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_request_q_2", durable = "true"),
                                             exchange = @Exchange(name = "notify_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_key_2"))
    @SendTo("notify_response_exchange/notify_response")
    public NotifyResponse handle2(final NotifyRequest str) {
        System.out.println("Handle 2 : " + str);
        return new NotifyResponse(str.getOrderId(),
                                  1);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_request_q_3", durable = "true"),
                                             exchange = @Exchange(name = "notify_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_key_3"))
    @SendTo("notify_response_exchange/notify_response")
    public NotifyResponse handle3(final NotifyRequest str) {
        System.out.println("Handle 3 : " + str);
        return new NotifyResponse(str.getOrderId(),
                                  1);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_topic_1", durable = "true"),
                                             exchange = @Exchange(name = "notify_topic_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "com.ykb.#"))
    public void handle4(final NotifyRequest str) {
        System.out.println("Topic 1 : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_topic_2", durable = "true"),
                                             exchange = @Exchange(name = "notify_topic_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "com.ykb.it.*"))
    public void handle5(final NotifyRequest str) {
        System.out.println("Topic 2 : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_topic_3", durable = "true"),
                                             exchange = @Exchange(name = "notify_topic_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "com.*.it"))
    public void handle6(final NotifyRequest str) {
        System.out.println("Topic 3 : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_fanout_1", durable = "true"),
                                             exchange = @Exchange(name = "notify_fanout_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.FANOUT),
                                             key = "com.ykb.#"))
    public void handle7(final NotifyRequest str) {
        System.out.println("Topic 1 : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_fanout_2", durable = "true"),
                                             exchange = @Exchange(name = "notify_fanout_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.FANOUT),
                                             key = "com.ykb.it.*"))
    public void handle8(final NotifyRequest str) {
        System.out.println("Topic 2 : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_fanout_3", durable = "true"),
                                             exchange = @Exchange(name = "notify_fanout_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.FANOUT),
                                             key = "com.*.it"))
    public void handle9(final NotifyRequest str) {
        System.out.println("Topic 3 : " + str);
    }

}
