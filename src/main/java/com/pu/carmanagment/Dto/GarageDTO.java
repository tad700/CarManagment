package com.pu.carmanagment.Dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GarageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "garageId")
    private Long garageid;
    private String name;
    private String location;
    private String city;
    private int capacity;


}
