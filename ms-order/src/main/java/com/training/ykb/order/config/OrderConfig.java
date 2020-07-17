package com.training.ykb.order.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
// @RibbonClient(name = "ACCOUNTING", configuration = AccountingRibbonClientConfig.class)
public class OrderConfig {

    @Bean
    @LoadBalanced
    @Qualifier("loadbalanced")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("direct")
    public RestTemplate restTemplateDirect() {
        return new RestTemplate();
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
