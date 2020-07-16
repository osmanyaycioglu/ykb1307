package com.training.ykb.order.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

// @Configuration
public class AccountingRibbonClientConfig {

    @Bean
    public IRule myRule() {
        return new BestAvailableRule();
    }

    public IPing myPing() {
        return new NoOpPing();
    }

}
