package com.training.ykb.account.models;


public class PaymentResponse {

    private Long    orderId;
    private Integer orderResult;
    private String  msIp;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Integer getOrderResult() {
        return this.orderResult;
    }

    public void setOrderResult(final Integer orderResultParam) {
        this.orderResult = orderResultParam;
    }

    public String getMsIp() {
        return this.msIp;
    }

    public void setMsIp(final String msIpParam) {
        this.msIp = msIpParam;
    }

    @Override
    public String toString() {
        return "PaymentResponse [orderId="
               + this.orderId
               + ", orderResult="
               + this.orderResult
               + ", msIp="
               + this.msIp
               + "]";
    }


}
