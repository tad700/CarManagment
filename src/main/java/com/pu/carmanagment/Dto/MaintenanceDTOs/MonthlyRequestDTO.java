package com.pu.carmanagment.Dto.MaintenanceDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyRequestDTO {

    private YearMonth yearMonth;
    private int requests;
}
