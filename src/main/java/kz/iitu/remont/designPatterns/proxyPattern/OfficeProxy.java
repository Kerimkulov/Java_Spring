package kz.iitu.remont.designPatterns.proxyPattern;

import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.Reapirier;
import kz.iitu.remont.designPatterns.StatePattern.Available;

public class OfficeProxy implements ProxyInterface {
    private static RepairOffice rp=new RepairOffice();
    @Override
    public String addRep(Reapirier r) {
        if(rp.Repariers.isEmpty()){
            rp.Repariers.add(r);
            return " Reparier with id: "+r.getIdOfRoom() + " is successfully added!!!";
        }
        else{
            if(rp.Repariers.contains(r)){
                return("Reparier with id: "+ r.getIdOfRoom() +" is already added!");
            }
            else{
                rp.Repariers.add(r);
                return (" Reparier with id: "+r.getIdOfRoom() + " is successfully added!!!");
            }
        }
    }
    @Override
    public String Repairing(Device s, Reapirier r) {
        if(rp.Repariers.contains(r)){
            if(r.getState() instanceof Available){
                r.NotAvailableRep();
                rp.Repairing(s, r);
                return "Reparier got your device";
            }
            else {
                return("Raparier is not available!!!");
            }
        }
        else{
            return("there is no such reparier");
        }
    }

    @Override
    public String displayRepsDevices(Reapirier r) {
        if(rp.Repariers.contains(r)){
            return rp.displayRepsDevices(r);

        }
        else{
            return ("Oh no!There is not such reparier!");
        }
    }

    @Override
    public String EndOfRepairing( Reapirier r) {
        if(rp.Repariers.contains(r)){
            rp.EndOfRepairing(r);
            r.AvailableRep();
            return "This reparier is available now";
        }
        else{
            return("Oh no!There is not such reparier!");
        }
    }

    @Override
    public Boolean readyDevice(Reapirier reapirier) {
        if(rp.Repariers.contains(reapirier)){
            return rp.readyDevice(reapirier);
        }
        else {
            return false;
        }
    }
}
