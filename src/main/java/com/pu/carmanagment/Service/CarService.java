package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;


import java.util.List;


public interface CarService {
    ResponseCarDTO findCarById(int id);
    List<ResponseCarDTO> getAll();
    CreateCarDTO createCar(CreateCarDTO car);
    UpdateCarDTO updateCar(int id, UpdateCarDTO updatedCar);

    void deleteCar(int id);




}
