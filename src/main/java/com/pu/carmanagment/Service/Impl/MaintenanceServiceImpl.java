package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Entity.Maintenance;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Mapper.MaintenanceMapper;
import com.pu.carmanagment.Repository.MaintenanceRepository;
import com.pu.carmanagment.Service.MaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {
   MaintenanceRepository maintenanceRepository;

    @Override
    public ResponseMaintenanceDTO findGarageById(Long id) {
        Maintenance newMaintenance = maintenanceRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("maintenance not found with id"+id));
        return MaintenanceMapper.mapToResponseMaintenanceDTO(newMaintenance);
    }

    @Override
    public List<ResponseMaintenanceDTO> findAll() {
       List<Maintenance> maintenanceList = maintenanceRepository.findAll();
       return maintenanceList.stream()
               .map(MaintenanceMapper::mapToResponseMaintenanceDTO)
               .collect(Collectors.toList());
    }

    @Override
    public CreateMaintenanceDTO createMaintenance(CreateMaintenanceDTO maintenance) {

        Maintenance maintenance1 = new Maintenance(
                maintenance.getId(),
                maintenance.getCarId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getGarageId(),
                maintenance.getGarageName(),
                maintenance.getScheduledDate()
        );
        maintenanceRepository.save(maintenance1);
        return MaintenanceMapper.mapToCreateMaintenanceDTO(maintenance1);
    }

    @Override
    public UpdateMaintenanceDTO updateMaintenance(Long id, UpdateMaintenanceDTO updatedMaintenance) {
        Maintenance maintenance = maintenanceRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("maintenance is not found with id "+id)
        );
       maintenance.setId(updatedMaintenance.getId());
       maintenance.setCarName(updatedMaintenance.getCarName());
       maintenance.setServiceType(updatedMaintenance.getServiceType());
       maintenance.setGarageId(maintenance.getGarageId());
       maintenance.setScheduledDate(maintenance.getScheduledDate());
       maintenanceRepository.save(maintenance);
       return MaintenanceMapper.mapToUpdateMaintenanceDTO(maintenance);
    }

    @Override
    public void deleteMaintenance(Long id) {

    }
}
