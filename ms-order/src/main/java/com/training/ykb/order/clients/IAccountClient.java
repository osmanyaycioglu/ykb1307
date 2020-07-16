package com.training.ykb.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.account.models.PaymentRequest;
import com.training.ykb.account.models.PaymentResponse;

@FeignClient(name = "accounting")
@RequestMapping("/account/v1")
public interface IAccountClient {

    @PostMapping("/pay")
    public PaymentResponse xyz(@RequestBody final PaymentRequest pr);

}
