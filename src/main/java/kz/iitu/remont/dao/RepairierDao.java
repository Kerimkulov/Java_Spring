package kz.iitu.remont.dao;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.designPatterns.proxyPattern.OfficeProxy;
import kz.iitu.remont.designPatterns.proxyPattern.ProxyInterface;
import kz.iitu.remont.entities.Reapirier;
import kz.iitu.remont.event.BusyReparierEvent;
import kz.iitu.remont.event.FreeReparierEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class RepairierDao implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;
    private ProxyInterface proxyInterface = new OfficeProxy();

    public void createRepairier(Reapirier reapirier){
        proxyInterface.addRep(reapirier);
        this.eventPublisher.publishEvent(new FreeReparierEvent(this, reapirier));
    }

    public void startRepair(Device device, Reapirier reapirier){
        proxyInterface.Repairing(device, reapirier);
        this.eventPublisher.publishEvent(new BusyReparierEvent(this, reapirier, device));
    }

    public void endRepair(Reapirier reapirier){
        proxyInterface.EndOfRepairing(reapirier);
        this.eventPublisher.publishEvent(new FreeReparierEvent(this, reapirier));
    }

    public void listOfRepairiers(Reapirier reapirier){
        proxyInterface.displayRepsDevices(reapirier);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
