package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Entity.Car;

import java.util.List;


public interface CarService {
    ResponseCarDTO findCarById(Long id);
    CreateCarDTO addCar(CreateCarDTO car);

    void deleteCar(Long id);
    List<ResponseCarDTO> listAll();

    UpdateCarDTO updateCar(Long id, UpdateCarDTO updatedCar);

}
