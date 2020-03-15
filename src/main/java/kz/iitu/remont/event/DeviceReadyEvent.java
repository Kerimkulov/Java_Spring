package kz.iitu.remont.event;

import kz.iitu.remont.entities.Device;
import org.springframework.context.ApplicationEvent;

public class DeviceReadyEvent extends ApplicationEvent {
    private Device device;

    public DeviceReadyEvent(Object source, Device device) {
        super(source);
        this.device = device;
    }

    public Device getDevice(){
        return this.device;
    }
}
