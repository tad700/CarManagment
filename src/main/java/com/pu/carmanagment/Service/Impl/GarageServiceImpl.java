package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.GarageDailyAvailabilityReportDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Entity.Maintenance;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Mapper.GarageMapper;
import com.pu.carmanagment.Repository.GarageRepository;
import com.pu.carmanagment.Repository.MaintenanceRepository;
import com.pu.carmanagment.Service.GarageService;
import com.pu.carmanagment.Service.MaintenanceService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    GarageRepository garageRepository;
    MaintenanceService maintenanceService;

    @Autowired
    GarageServiceImpl(GarageRepository garageRepository,MaintenanceService maintenanceService){
        this.maintenanceService = maintenanceService;
        this.garageRepository = garageRepository;
    }

    @Override
    public ResponseGarageDTO findGarageById(Integer id) {

        Garage garage = garageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Garage is not found with id "+id));
        return GarageMapper.mapToResponseGarageDTO(garage);

    }

    @Override
    public CreateGarageDTO createGarage(CreateGarageDTO garage) {
       Garage savedGarage = new Garage();
       savedGarage.setId(garage.getId());
       savedGarage.setName(garage.getName());
       savedGarage.setLocation(garage.getLocation());
       savedGarage.setCity(garage.getCity());
       savedGarage.setCapacity(garage.getCapacity());
        garageRepository.save(savedGarage);

        return  GarageMapper.mapToCreateGarageDTO(savedGarage);

    }

    @Override
    public void deleteGarage(Integer id) {
       Garage garageToDelete = garageRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Garage is not found with id "+ id));
       garageRepository.delete(garageToDelete);
    }

    @Override
    public List<ResponseGarageDTO> listALl() {
        List<Garage> garages= garageRepository.findAll();

        return garages.stream()
                .map(GarageMapper::mapToResponseGarageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateGarageDTO updateGarage(Integer id, UpdateGarageDTO updatedGarage) {
        Garage garage = garageRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Garage is not found with id "+id));
        garage.setName(updatedGarage.getName());
        garage.setLocation(updatedGarage.getLocation());
        garage.setCity(updatedGarage.getCity());
        garage.setCapacity(updatedGarage.getCapacity());
        garageRepository.save(garage);

        return GarageMapper.mapToUpdateGarageDTO(garage);
    }

    @Override
    public GarageDailyAvailabilityReportDTO dailyAvailabilityReport(Integer garageId, YearMonth startDate, YearMonth endDate) {
        return null;
    }


}

