package kz.iitu.remont.designPatterns.proxyPattern;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.Reapirier;

public interface ProxyInterface {
    String addRep(Reapirier r);
    String Repairing(Device d, Reapirier r);
    String displayRepsDevices(Reapirier r);
    String EndOfRepairing(Reapirier r);
    Boolean readyDevice(Reapirier reapirier);
}
