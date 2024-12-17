package com.pu.carmanagment.Dto.MaintenanceDTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private String carName;
    private String serviceType;
    private Long garageId;
    private String garageName;
    LocalDate scheduledDate;
}
