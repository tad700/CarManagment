package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Entity.Car;
import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Repository.GarageRepository;
import com.pu.carmanagment.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {

    GarageRepository garageRepository;
    @Autowired
    GarageServiceImpl(GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage findGarageById(Long id) {
        return garageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Garage is not found with id "+id)
        );
    }

    @Override
    public Garage addGarage(Garage garage) {
       Garage savedGarage = new Garage(garage.getGarageid(),
               garage.getName(),
               garage.getLocation(),
               garage.getCity(),
               garage.getCapacity());
       return garageRepository.save(savedGarage);
    }

    @Override
    public void deleteGarage(Long id) {
       Garage garage = garageRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Garage is not found with id "+ id));
    }

    @Override
    public List<Garage> listALl() {
        return garageRepository.findAll();
    }

    @Override
    public Garage updateGarage(Long id, Garage updatedGarage) {
        Garage garage = garageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Garage is not found with id "+id));
        garage.setName(updatedGarage.getName());
        garage.setLocation(updatedGarage.getLocation());
        garage.setCity(updatedGarage.getCity());
        garage.setCapacity(updatedGarage.getCapacity());

        return garageRepository.save(garage);
    }
}
