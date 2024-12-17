package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Entity.Maintenance;

import java.time.LocalDate;
import java.util.List;

public interface MaintenanceService {
    ResponseMaintenanceDTO findGarageById(Long id);
    List<ResponseMaintenanceDTO> findAll();

    CreateMaintenanceDTO createMaintenance(Long carId, Long garageID, CreateMaintenanceDTO maintenance);

    UpdateMaintenanceDTO updateMaintenance(Long id, UpdateMaintenanceDTO maintenance);
    void deleteMaintenance(Long id);


}
