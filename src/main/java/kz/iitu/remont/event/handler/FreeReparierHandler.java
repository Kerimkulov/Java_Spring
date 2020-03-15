package kz.iitu.remont.event.handler;

import kz.iitu.remont.event.BusyReparierEvent;
import kz.iitu.remont.event.FreeReparierEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FreeReparierHandler implements ApplicationListener<FreeReparierEvent> {
    @Override
    public void onApplicationEvent(FreeReparierEvent freeReparierEvent) {
        System.out.println(freeReparierEvent.getReapirier() + " is free now and ready to repair your device");
    }
}
