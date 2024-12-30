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
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    GarageRepository garageRepository;
    MaintenanceRepository maintenanceRepository;
    MaintenanceService maintenanceService;


    @Autowired
    GarageServiceImpl(GarageRepository garageRepository,MaintenanceRepository maintenanceRepository,MaintenanceService maintenanceService){
        this.maintenanceService = maintenanceService;
        this.garageRepository = garageRepository;
        this.maintenanceRepository = maintenanceRepository;
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
    public List<GarageDailyAvailabilityReportDTO> dailyAvailabilityReport(Integer garageId, YearMonth startDate, YearMonth endDate) {
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new ResourceNotFoundException("Garage not found with id " + garageId));

        List<Maintenance> maintenances = maintenanceRepository.findByGarageIdAndDateRange(
                garageId, startDate.atDay(1), endDate.atEndOfMonth());

        Map<LocalDate, Long> dailyRequests = maintenances.stream()
                .collect(Collectors.groupingBy(
                        Maintenance::getScheduledDate,
                        Collectors.counting()));

        List<GarageDailyAvailabilityReportDTO> dailyReport = new ArrayList<>();
        LocalDate current = startDate.atDay(1);
        LocalDate end = endDate.atEndOfMonth();

        while (!current.isAfter(end)) {
            int requests = dailyRequests.getOrDefault(current, 0L).intValue();
            int availableCapacity = garage.getCapacity() - requests;

            dailyReport.add(new GarageDailyAvailabilityReportDTO(
                    current.toString(),
                    requests,
                    availableCapacity
            ));

            current = current.plusDays(1);
        }

        return dailyReport;
    }




}

