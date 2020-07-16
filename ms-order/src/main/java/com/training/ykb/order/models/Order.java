package com.training.ykb.order.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class Order {

    @Null
    private Long         orderId;
    @NotNull
    private Long         customerId;
    @Size(min = 1, max = 30)
    private List<String> orderedItems;

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

    public List<String> getOrderedItems() {
        return this.orderedItems;
    }

    public void setOrderedItems(final List<String> orderedItemsParam) {
        this.orderedItems = orderedItemsParam;
    }

    @Override
    public String toString() {
        return "Order [orderId="
               + this.orderId
               + ", customerId="
               + this.customerId
               + ", orderedItems="
               + this.orderedItems
               + "]";
    }


}
