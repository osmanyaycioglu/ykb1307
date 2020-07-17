package com.training.ykb.notify.models;

public class NotifyRequest {

    private long   orderId;
    private String name;
    private String cellNumber;
    private String email;

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getCellNumber() {
        return this.cellNumber;
    }

    public void setCellNumber(final String cellNumberParam) {
        this.cellNumber = cellNumberParam;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    @Override
    public String toString() {
        return "NotifyRequest [orderId="
               + this.orderId
               + ", name="
               + this.name
               + ", cellNumber="
               + this.cellNumber
               + ", email="
               + this.email
               + "]";
    }


}
