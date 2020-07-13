package com.training.ykb;

import org.springframework.stereotype.Component;

// Default Singleton
@Component
public class MyFirstBean {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
