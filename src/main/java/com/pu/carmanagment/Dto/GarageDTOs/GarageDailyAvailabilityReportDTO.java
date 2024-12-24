package com.pu.carmanagment.Dto.GarageDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GarageDailyAvailabilityReportDTO {

    private String date;
    private int requests;
    private int availableCapacity;
}
