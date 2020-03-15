package kz.iitu.remont.event;

import kz.iitu.remont.entities.Reapirier;
import org.springframework.context.ApplicationEvent;

public class FreeReparierEvent extends ApplicationEvent {
    private Reapirier reapirier;

    public FreeReparierEvent(Object source, Reapirier reapirier) {
        super(source);
        this.reapirier = reapirier;
    }
    public Reapirier getReapirier(){
        return this.reapirier;
    }
}
