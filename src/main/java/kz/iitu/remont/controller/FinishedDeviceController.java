package kz.iitu.remont.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.remont.entities.Device;
import kz.iitu.remont.entities.FinishedDevices;
import kz.iitu.remont.repository.DeviceRepository;
import kz.iitu.remont.repository.FinishedDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/finishedDevices")
@Api(value = "FinishedDevice Controller class", description = "This class allows to interact with FinishedDevice object")
public class FinishedDeviceController {

    @Autowired
    private FinishedDeviceRepository finishedDeviceRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @ApiOperation(value = "List of all finished devices")
    @GetMapping("")
    public List<FinishedDevices> repairCenterList(){
        return finishedDeviceRepository.findAll();
    }


    @ApiOperation(value = "End of repairing")
    @PostMapping("/{deviceId}")
    public void endOfRepairing( @PathVariable Long deviceId){
        LocalDate date = LocalDate.now();
        Device device = deviceRepository.findById(deviceId).get();
        FinishedDevices finishedDevices = new FinishedDevices();
        finishedDevices.setDevice(device);
        finishedDevices.setDate(date);
        finishedDevices.setIsTaken(false);
        finishedDeviceRepository.save(finishedDevices);
    }

    @ApiOperation(value = "Take finished device")
    @PatchMapping("/{id}")
    public void takeFinishedDevice(@PathVariable Long id){
        Device device = deviceRepository.findById(id).get();
        FinishedDevices finishedDevices = finishedDeviceRepository.findByDevice(device);
        finishedDevices.setIsTaken(true);
        finishedDeviceRepository.save(finishedDevices);
    }


}
