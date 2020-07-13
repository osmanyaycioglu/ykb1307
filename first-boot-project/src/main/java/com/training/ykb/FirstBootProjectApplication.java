package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @Controller
// @Configuration
// @Repository
// @Service
public class FirstBootProjectApplication {

    @Autowired
    private MyFirstBean mb;

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(FirstBootProjectApplication.class,
                                                                      args);
        FirstBootProjectApplication beanLoc = runLoc.getBean(FirstBootProjectApplication.class);
        beanLoc.mb.setName("osman");

    }

}
