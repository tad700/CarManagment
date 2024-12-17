package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Entity.*;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Mapper.MaintenanceMapper;
import com.pu.carmanagment.Repository.CarRepository;
import com.pu.carmanagment.Repository.GarageRepository;
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
   CarRepository carRepository;
   GarageRepository garageRepository;

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
    public CreateMaintenanceDTO createMaintenance(Long carId, Long garageId, CreateMaintenanceDTO maintenance) {
        Car car = carRepository.findById(carId).orElseThrow(
                ()-> new ResourceNotFoundException("car is not found with id"+carId)
        );
        Garage garage = garageRepository.findById(garageId).orElseThrow(
                () -> new ResourceNotFoundException("Garage is not found with id "+garageId));



        Maintenance savedMaintenance = new Maintenance();
        savedMaintenance.setCarId(car.getId());
        savedMaintenance.setCarName(car.getMake()+" "+car.getModel());
        savedMaintenance.setGarageId(garage.getId());
        savedMaintenance.setGarageName(garage.getName());
        savedMaintenance.setServiceType(maintenance.getServiceType());
        savedMaintenance.setScheduledDate(maintenance.getScheduledDate());
        maintenanceRepository.save(savedMaintenance);
        return MaintenanceMapper.mapToCreateMaintenanceDTO(savedMaintenance);
    }

    @Override
    public UpdateMaintenanceDTO updateMaintenance(Long id, UpdateMaintenanceDTO updatedMaintenance) {
        Maintenance maintenance = maintenanceRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("maintenance is not found with id "+id)
        );
       maintenance.setId(updatedMaintenance.getId());
       maintenance.setCarId(updatedMaintenance.getCarId());
       maintenance.setCarName(updatedMaintenance.getCarName());
       maintenance.setServiceType(updatedMaintenance.getServiceType());
       maintenance.setGarageId(updatedMaintenance.getGarageId());
       maintenance.setGarageName(updatedMaintenance.getGarageName());
       maintenance.setScheduledDate(updatedMaintenance.getScheduledDate());
       maintenanceRepository.save(maintenance);
       return MaintenanceMapper.mapToUpdateMaintenanceDTO(maintenance);
    }

    @Override
    public void deleteMaintenance(Long id) {

    }
}
