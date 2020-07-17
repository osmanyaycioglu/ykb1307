package com.training.ykb;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {

    private static final long serialVersionUID = 4685533776007805741L;
    private String            xyz;
    private String            abc;

    public MyRemoteEvent() {
    }

    public MyRemoteEvent(final Object source,
                         final String id) {
        super(source,
              id);
    }


    public String getXyz() {
        return this.xyz;
    }


    public void setXyz(final String xyzParam) {
        this.xyz = xyzParam;
    }


    public String getAbc() {
        return this.abc;
    }


    public void setAbc(final String abcParam) {
        this.abc = abcParam;
    }

    @Override
    public String toString() {
        return "MyRemoteEvent [xyz=" + this.xyz + ", abc=" + this.abc + "]";
    }


}
