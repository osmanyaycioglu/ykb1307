package com.training.ykb.account.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PaymentRequest {

    @NotNull
    @Positive
    private Long    orderId;
    @NotNull
    @Positive
    private Long    customerId;
    @NotNull
    @Positive
    @Min(10)
    private Integer amount;


    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }

}
