package kz.iitu.remont.entities;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private String DeviceName;
    private String year;
    private String manufacturer;
    private String explanation;


    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public String getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Device{" +
                "DeviceName='" + DeviceName + '\'' +
                '}';
    }
}
