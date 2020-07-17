package com.training.ykb.notify.models;


public class NotifyResponse {

    private long orderId;
    private int  result;

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(final int resultParam) {
        this.result = resultParam;
    }

    @Override
    public String toString() {
        return "NotifyResponse [orderId=" + this.orderId + ", result=" + this.result + "]";
    }


}
