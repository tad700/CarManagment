package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;


import java.util.List;


public interface CarService {
    ResponseCarDTO findCarById(Long id);
    List<ResponseCarDTO> getAll();
    CreateCarDTO addCar(CreateCarDTO car);
    UpdateCarDTO updateCar(Long id, UpdateCarDTO updatedCar);

    void deleteCar(Long id);




}
