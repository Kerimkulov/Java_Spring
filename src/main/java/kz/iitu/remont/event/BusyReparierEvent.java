package kz.iitu.remont.event;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.Reapirier;
import org.springframework.context.ApplicationEvent;

public class BusyReparierEvent extends ApplicationEvent {
    private Reapirier reapirier;
    private Device device;

    public BusyReparierEvent(Object source, Reapirier reapirier, Device device) {
        super(source);
        this.reapirier = reapirier;
        this.device = device;
    }
    public Reapirier getReapirier(){
        return this.reapirier;
    }
    public Device getDevice(){
        return this.device;
    }
}
