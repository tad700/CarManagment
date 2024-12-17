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
    private Long id;
    @Transient
    private Car car;

    private Long carId;
    private String carName;

    @Transient
    private Garage garage;
    private Long garageId;
    private String garageName;

    private String serviceType;

    LocalDate scheduledDate;


    public Maintenance(Long id, Long carId, String serviceType, Long garageId, LocalDate scheduledDate) {

    }
}
