package com.pu.carmanagment.Mapper;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Entity.Maintenance;

public class MaintenanceMapper {

    public static ResponseMaintenanceDTO mapToResponseMaintenanceDTO(Maintenance maintenance) {
        return new ResponseMaintenanceDTO(

                maintenance.getId(),
                maintenance.getCarId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getGarageId(),
                maintenance.getGarageName(),
                maintenance.getScheduledDate()

        );
    }

    public static CreateMaintenanceDTO mapToCreateMaintenanceDTO(Maintenance maintenance) {
        return new CreateMaintenanceDTO(
                maintenance.getId(),
                maintenance.getCarId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getGarageId(),
                maintenance.getGarageName(),
                maintenance.getScheduledDate()

        );
    }

    public static UpdateMaintenanceDTO mapToUpdateMaintenanceDTO(Maintenance maintenance) {
        return new UpdateMaintenanceDTO(
                maintenance.getId(),
                maintenance.getCarId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getGarageId(),
                maintenance.getGarageName(),
                maintenance.getScheduledDate()
        );
    }
}
