package com.training.ykb.account.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                     .withDetail("ok",
                                 "herşey iyi")
                     .build();
    }

}
