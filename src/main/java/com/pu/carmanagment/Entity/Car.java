package com.pu.carmanagment.Entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    private int productionYear;

    private String licensePlate;

    @OneToMany(mappedBy = "id")
    private List<Garage> garages;
}
