package kz.iitu.remont.entities;

import kz.iitu.remont.designPatterns.StatePattern.ReparierStates;

import java.util.ArrayList;

public class Reapirier {
    public ArrayList<Device> ReparierDevices=new ArrayList<>();
    private ReparierStates ps;
    private String name;
    private int idOfRoom;
    private int price;

    public String getName() {
        return name;
    }

    public int getIdOfRoom() {
        return idOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdOfRoom(int idOfRoom) {
        this.idOfRoom = idOfRoom;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPs(ReparierStates ps) {
        this.ps = ps;
    }
    public void AvailableRep(){
        ps.AvailableRep(this);
    }
    public void NotAvailableRep(){

        ps.NotAvailableRep(this);
    }

    public ReparierStates getState() {
        return ps;
    }


    @Override
    public String toString() {
        return "Reapirier{" +
                "ReparierDevices=" + ReparierDevices +
                ", ps=" + ps +
                ", name='" + name + '\'' +
                ", idOfRoom=" + idOfRoom +
                ", price=" + price +
                '}';
    }
}
