package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.GarageDailyAvailabilityReportDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;

import java.time.YearMonth;
import java.util.List;

public interface GarageService {

    ResponseGarageDTO findGarageById(Integer id);
    CreateGarageDTO createGarage(CreateGarageDTO garage);
    void deleteGarage(Integer id);
    List<ResponseGarageDTO> listALl();
    UpdateGarageDTO updateGarage(Integer id, UpdateGarageDTO updatedGarage);
    GarageDailyAvailabilityReportDTO dailyAvailabilityReport(Integer garageId, YearMonth startDate,YearMonth endDate);

}
