package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;

import java.util.List;

public interface MaintenanceService {
    ResponseMaintenanceDTO findGarageById(Long id);
    List<ResponseMaintenanceDTO> findAll();
    CreateMaintenanceDTO createMaintenance(CreateMaintenanceDTO maintenance);
    UpdateMaintenanceDTO updateMaintenance(Long id, UpdateMaintenanceDTO maintenance);
    void deleteMaintenance(Long id);


}
