package com.training.ykb;


public class NotifyResponse {

    private long orderId;
    private int  result;


    public NotifyResponse() {
    }


    public NotifyResponse(final long orderIdParam,
                          final int resultParam) {
        super();
        this.orderId = orderIdParam;
        this.result = resultParam;
    }


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

}
