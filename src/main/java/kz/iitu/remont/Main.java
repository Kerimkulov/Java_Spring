package kz.iitu.remont;

import kz.iitu.remont.designPatterns.StatePattern.Available;
import kz.iitu.remont.dao.DeviceDao;
import kz.iitu.remont.dao.RepairierDao;
import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.Reapirier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DeviceDao deviceDao = context.getBean("deviceDao", DeviceDao.class);
        RepairierDao repairierDao = context.getBean("repairierDao", RepairierDao.class);
        Available available = new Available();

        Device device = new Device();
        device.setDeviceName("Iphone");
        device.setExplanation("Change screen");
        device.setManufacturer("Apple");
        device.setYear("2012");

        Device device1 = new Device();
        device1.setDeviceName("Samsung");
        device1.setExplanation("Change screen");
        device1.setManufacturer("Samsung");
        device1.setYear("2015");

        Reapirier reapirier = new Reapirier();
        reapirier.setIdOfRoom(1);
        reapirier.setName("Aidos");
        reapirier.setPs(available);
        reapirier.setPrice(5000);

        Reapirier reapirier1 = new Reapirier();
        reapirier1.setIdOfRoom(2);
        reapirier1.setName("Arnur");
        reapirier1.setPs(available);
        reapirier1.setPrice(10000);
        System.out.println("");
        System.out.println("// Create reparier and add to list" +"\n");
        repairierDao.createRepairier(reapirier);
        repairierDao.createRepairier(reapirier1);

        System.out.println("//Starting reparing. Reparier and Reparier1"+"\n");
        repairierDao.startRepair(device, reapirier);
        repairierDao.startRepair(device1, reapirier1);

        System.out.println("// Check. Reparier is finished repairing of device"+"\n");
        deviceDao.getReadyDevice(reapirier, device);

        System.out.println("//Ending of repairing. Reparier"+"\n");
        repairierDao.endRepair(reapirier);

        System.out.println("//Again Check. Reparier is finished repairing of device"+"\n");
        deviceDao.getReadyDevice(reapirier, device);

        System.out.println("//Ending of repairing. Reparier1"+"\n");
        repairierDao.endRepair(reapirier1);

        System.out.println("//Starting reparing. Reparier"+"\n");
        repairierDao.startRepair(device1, reapirier);

        System.out.println("// List of all Repariers' devices"+"\n");
        repairierDao.listOfRepairiers(reapirier);



    }
}
