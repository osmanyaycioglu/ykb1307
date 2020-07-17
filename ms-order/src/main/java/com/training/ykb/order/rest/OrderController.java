package com.training.ykb.order.rest;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.training.ykb.account.models.PaymentRequest;
import com.training.ykb.account.models.PaymentResponse;
import com.training.ykb.notify.models.NotifyRequest;
import com.training.ykb.order.clients.IAccountClient;
import com.training.ykb.order.event.MyRemoteEvent;
import com.training.ykb.order.models.Order;

@RestController
@RequestMapping("/order/v1")
@RefreshScope
public class OrderController {

    private static final Logger logger  = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    @Qualifier("loadbalanced")
    private RestTemplate        rt;

    @Autowired
    @Qualifier("direct")
    private RestTemplate        rtd;

    @Value("${server.port}")
    private int                 port;

    @Autowired
    private EurekaClient        ec;

    @Autowired
    private IAccountClient      ac;

    @Autowired
    private RabbitTemplate      rTemplate;

    @Value("${my.prop.name}")
    private String              propName;

    @Autowired
    @Output(SpringCloudBusClient.OUTPUT)
    private MessageChannel      outputChannel;

    @Autowired
    private ApplicationContext  aContext;

    int                         counter = 0;

    @HystrixCommand(fallbackMethod = "cbFallback",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/circuitbreaker/{abc}")
    public String cb(@PathVariable("abc") final String name) {
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalStateException();
        }
        if ((this.counter % 5) == 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception eLoc) {
            }
        }
        return "Hello world " + name;
    }

    public String cbFallback(final String name) {
        return "Hello world Fallback ! " + name;
    }

    @GetMapping("/test")
    public String test() {
        MyRemoteEvent myRemoteEventLoc = new MyRemoteEvent(this,
                                                           this.aContext.getId());
        myRemoteEventLoc.setXyz("OSMAN");
        myRemoteEventLoc.setAbc("test");
        this.outputChannel.send(MessageBuilder.withPayload(myRemoteEventLoc)
                                              .build());
        return this.propName;
    }

    @GetMapping("/send")
    public String sendMessage() {
        Random randomLoc = new Random();
        NotifyRequest nr = new NotifyRequest();
        nr.setOrderId(randomLoc.nextInt());
        nr.setName("osman" + randomLoc.nextLong());
        nr.setEmail("os@os.com");
        nr.setCellNumber("" + randomLoc.nextLong());
        this.rTemplate.convertAndSend("notify_exchange",
                                      "notify_key_2",
                                      nr);
        return "OK";
    }

    @PostMapping("/submit")
    public String submit(@RequestBody final Order orderParam) {
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> " + orderParam);
        }
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(100);
        paymentRequestLoc.setOrderId((long) new Random().nextInt(100_000));
        PaymentResponse postForObjectLoc = this.ac.xyz(paymentRequestLoc);
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> Pay Request Response : " + postForObjectLoc);
        }

        return this.port + " OK : " + postForObjectLoc;
    }

    @PostMapping("/submit2")
    public String submit2(@RequestBody final Order orderParam) {
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> " + orderParam);
        }
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(100);
        paymentRequestLoc.setOrderId((long) new Random().nextInt(100_000));
        PaymentResponse postForObjectLoc = this.rt.postForObject("http://ACCOUNTING/account/v1/pay",
                                                                 paymentRequestLoc,
                                                                 PaymentResponse.class);
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> Pay Request Response : " + postForObjectLoc);
        }

        return "OK : " + postForObjectLoc;
    }

    @PostMapping("/submit3")
    public String submit3(@RequestBody final Order orderParam) {
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> " + orderParam);
        }
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(100);
        paymentRequestLoc.setOrderId((long) new Random().nextInt(100_000));

        Application applicationLoc = this.ec.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }

        InstanceInfo ins = this.ec.getNextServerFromEureka("ACCOUNTING",
                                                           false);

        PaymentResponse postForObjectLoc = this.rtd.postForObject("http://"
                                                                  + ins.getIPAddr()
                                                                  + ":"
                                                                  + ins.getPort()
                                                                  + "/account/v1/pay",
                                                                  paymentRequestLoc,
                                                                  PaymentResponse.class);
        if (OrderController.logger.isInfoEnabled()) {
            OrderController.logger.info("[OrderController][submit]-> Pay Request Response : " + postForObjectLoc);
        }

        return "OK : " + postForObjectLoc;
    }

}
