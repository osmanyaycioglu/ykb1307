package com.training.ykb;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyRemoteEventListener {


    @EventListener(MyRemoteEvent.class)
    public void handleEvent(final MyRemoteEvent eventParam) {
        System.out.println(eventParam);
    }

}
