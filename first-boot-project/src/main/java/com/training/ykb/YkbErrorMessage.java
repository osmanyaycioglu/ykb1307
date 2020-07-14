package com.training.ykb;

import java.util.ArrayList;
import java.util.List;

public class YkbErrorMessage {

    private String                subSystem;
    private String                boundedContext;
    private String                microservice;
    private String                desc;
    private int                   error;
    private List<YkbErrorMessage> subErrorMessages;


    public YkbErrorMessage() {
    }


    public YkbErrorMessage(final String subSystemParam,
                           final String boundedContextParam,
                           final String microserviceParam,
                           final String descParam,
                           final int errorParam) {
        super();
        this.subSystem = subSystemParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.error = errorParam;
    }


    public void add(final YkbErrorMessage errorMessageParam) {
        if (this.subErrorMessages == null) {
            this.subErrorMessages = new ArrayList<>();
        }
        this.subErrorMessages.add(errorMessageParam);
    }

    public String getSubSystem() {
        return this.subSystem;
    }

    public void setSubSystem(final String subSystemParam) {
        this.subSystem = subSystemParam;
    }

    public YkbErrorMessage subSystem(final String subSystemParam) {
        this.subSystem = subSystemParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public YkbErrorMessage boundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public void setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
    }

    public YkbErrorMessage microservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public YkbErrorMessage errorDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public int getError() {
        return this.error;
    }

    public void setError(final int errorParam) {
        this.error = errorParam;
    }

    public YkbErrorMessage errorIndex(final int errorParam) {
        this.error = errorParam;
        return this;
    }

    public YkbErrorMessage itCrmCustomer() {
        this.microservice = "CUSTOMER";
        this.subSystem = "IT";
        this.boundedContext = "CRM";
        return this;
    }

    public List<YkbErrorMessage> getSubErrorMessages() {
        return this.subErrorMessages;
    }

    public void setSubErrorMessages(final List<YkbErrorMessage> subErrorMessagesParam) {
        this.subErrorMessages = subErrorMessagesParam;
    }


}
