package com.pu.carmanagment.Service;

import com.pu.carmanagment.Entity.Garage;

import java.util.List;

public interface GarageService {

    Garage findGarageById(Long id);
    Garage addGarage(Garage garage);
    void deleteGarage(Long id);
    List<Garage> listALl();
    Garage updateGarage(Long id,Garage updatedGarage);

}
