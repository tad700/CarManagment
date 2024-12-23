package com.pu.carmanagment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient
    private Car car;

    private int carId;
    private String carName;

    @Transient
    private Garage garage;
    private int garageId;
    private String garageName;

    private String serviceType;

    LocalDate scheduledDate;


    public Maintenance(Long id, Long carId, String serviceType, Long garageId, LocalDate scheduledDate) {

    }
}
