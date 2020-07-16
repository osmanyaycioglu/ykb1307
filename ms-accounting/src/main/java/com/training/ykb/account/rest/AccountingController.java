package com.training.ykb.account.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.account.models.PaymentRequest;
import com.training.ykb.account.models.PaymentResponse;

@RestController
@RequestMapping("/account/v1")
public class AccountingController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/pay")
    public PaymentResponse pay(final PaymentRequest pr) {
        System.out.println(pr);
        PaymentResponse paymentResponseLoc = new PaymentResponse();
        paymentResponseLoc.setOrderId(pr.getOrderId());
        paymentResponseLoc.setOrderResult(1);
        paymentResponseLoc.setMsIp("127.0.0.1:" + this.port);
        return paymentResponseLoc;
    }

}
