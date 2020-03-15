package kz.iitu.remont.designPatterns.proxyPattern;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.Reapirier;
import kz.iitu.remont.designPatterns.StatePattern.Available;

import java.util.ArrayList;

public class RepairOffice implements ProxyInterface{
    public ArrayList<Reapirier> Repariers=new ArrayList<>();
    public RepairOffice() {
    }
    public String addRep(Reapirier repariers){
        Repariers.add(repariers);
        return "";
    }
    public String displayRepsDevices(Reapirier r){
        for(int i=0;i<r.ReparierDevices.size();i++){
            return ("Reparier with id: "+r.getIdOfRoom()+" is repairing "+ r.ReparierDevices.get(i).toString());
        }
        return "";
    }
    public String Repairing(Device s, Reapirier r){
        r.ReparierDevices.add(s);
        return ("Your device is repairing by reparier which id is "+r.getIdOfRoom());

    }

    @Override
    public String EndOfRepairing(Reapirier r) {
        r.AvailableRep();
        return "";
    }

    @Override
    public Boolean readyDevice(Reapirier reapirier) {
        if( reapirier.getState() instanceof Available){
            return true;
        }
        else {
           return false;
        }
    }

}
