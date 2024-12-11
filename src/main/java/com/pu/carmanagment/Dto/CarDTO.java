package com.pu.carmanagment.Dto;

import com.pu.carmanagment.Entity.Garage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    private int productionYear;

    private String licensePlate;

    @OneToMany(mappedBy = "garageid")
    private List<Garage> garages;
}
