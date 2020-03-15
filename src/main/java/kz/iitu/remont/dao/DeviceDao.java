package kz.iitu.remont.dao;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.designPatterns.proxyPattern.OfficeProxy;
import kz.iitu.remont.designPatterns.proxyPattern.ProxyInterface;
import kz.iitu.remont.entities.Reapirier;
import kz.iitu.remont.event.DeviceReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class DeviceDao implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;
    private ProxyInterface proxyInterface = new OfficeProxy();

    public void getReadyDevice(Reapirier reapirier, Device device){
        if(proxyInterface.readyDevice(reapirier)){
            this.eventPublisher.publishEvent(new DeviceReadyEvent(this, device));
        }
        else {
            System.out.println("Your device is not ready");
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
