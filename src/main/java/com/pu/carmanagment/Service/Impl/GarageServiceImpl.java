package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Mapper.GarageMapper;
import com.pu.carmanagment.Repository.GarageRepository;
import com.pu.carmanagment.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    GarageRepository garageRepository;
    @Autowired
    GarageServiceImpl(GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    @Override
    public ResponseGarageDTO findGarageById(Long id) {

        Garage garage = garageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Garage is not found with id "+id));
        return GarageMapper.mapToResponseGarageDTO(garage);

    }

    @Override
    public CreateGarageDTO createGarage(CreateGarageDTO garage) {
       Garage savedGarage = new Garage(garage.getGarageid(),
               garage.getName(),
               garage.getLocation(),
               garage.getCity(),
               garage.getCapacity());
        garageRepository.save(savedGarage);

        return  GarageMapper.mapToCreateGarageDTO(savedGarage);

    }

    @Override
    public void deleteGarage(Long id) {
       Garage garage = garageRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Garage is not found with id "+ id));
    }

    @Override
    public List<ResponseGarageDTO> listALl() {
        List<Garage> garages= garageRepository.findAll();

        return garages.stream().map(GarageMapper::mapToResponseGarageDTO).collect(Collectors.toList());
    }

    @Override
    public UpdateGarageDTO updateGarage(Long id, Garage updatedGarage) {
        Garage garage = garageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Garage is not found with id "+id));
        garage.setName(updatedGarage.getName());
        garage.setLocation(updatedGarage.getLocation());
        garage.setCity(updatedGarage.getCity());
        garage.setCapacity(updatedGarage.getCapacity());
        garageRepository.save(garage);

        return GarageMapper.mapToUpdateGarageDTO(garage);
    }
}
