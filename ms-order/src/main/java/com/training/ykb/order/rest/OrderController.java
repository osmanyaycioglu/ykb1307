package com.training.ykb.order.rest;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.account.models.PaymentRequest;
import com.training.ykb.account.models.PaymentResponse;
import com.training.ykb.order.clients.IAccountClient;
import com.training.ykb.order.models.Order;

@RestController
@RequestMapping("/order/v1")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    @Qualifier("loadbalanced")
    private RestTemplate        rt;

    @Autowired
    @Qualifier("direct")
    private RestTemplate        rtd;

    @Autowired
    private EurekaClient        ec;

    @Autowired
    private IAccountClient      ac;

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

        return "OK : " + postForObjectLoc;
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
