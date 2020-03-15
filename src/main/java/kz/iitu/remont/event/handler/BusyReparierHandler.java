package kz.iitu.remont.event.handler;

import kz.iitu.remont.event.BusyReparierEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BusyReparierHandler implements ApplicationListener<BusyReparierEvent> {
    @Override
    public void onApplicationEvent(BusyReparierEvent busyReparierEvent) {
        System.out.println(busyReparierEvent.getReapirier() + " take the " + busyReparierEvent.getDevice());
    }
}
