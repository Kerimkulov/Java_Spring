package kz.iitu.remont.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DeviceName;
    private String year;
    private String manufacturer;
    private String explanation;
    private Boolean isDone = false;
    private String deviceOwnerPhone;
    private String deviceOwnerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reparier_id")
    private Reparier reparier;

    @OneToOne(mappedBy = "device", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FinishedDevices finishedDevices;
}
