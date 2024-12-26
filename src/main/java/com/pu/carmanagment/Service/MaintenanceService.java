package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.MonthlyRequestDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Entity.Maintenance;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface MaintenanceService {
    ResponseMaintenanceDTO findGarageById(Integer id);
    List<ResponseMaintenanceDTO> getMaintenance(Integer carId, Integer garageId, YearMonth startDate,YearMonth endDate);

    CreateMaintenanceDTO createMaintenance(Integer carId, Integer garageID, CreateMaintenanceDTO maintenance);

    UpdateMaintenanceDTO updateMaintenance(Integer id, UpdateMaintenanceDTO maintenance);
    void deleteMaintenance(Integer id);

    List<Maintenance> getAll();

    List<MonthlyRequestDTO> monthlyRequest(int garageId, YearMonth startDate, YearMonth endDate);


}
