package kz.iitu.remont.event.handler;

import kz.iitu.remont.event.DeviceReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DeviceReadyHandler implements ApplicationListener<DeviceReadyEvent> {
    @Override
    public void onApplicationEvent(DeviceReadyEvent deviceReadyEvent) {
        System.out.println(deviceReadyEvent.getDevice() + " device is ready for use.");
    }
}
