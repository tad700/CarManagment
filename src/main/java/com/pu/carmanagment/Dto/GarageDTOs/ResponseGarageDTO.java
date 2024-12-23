package com.pu.carmanagment.Dto.GarageDTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGarageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "garageId")
    private int id;
    private String name;
    private String location;
    private String city;
    private int capacity;


}
