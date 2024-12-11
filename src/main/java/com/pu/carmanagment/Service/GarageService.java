package com.pu.carmanagment.Service;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;

import java.util.List;

public interface GarageService {

    ResponseGarageDTO findGarageById(Long id);
    CreateGarageDTO addGarage(Garage garage);
    void deleteGarage(Long id);
    List<ResponseGarageDTO> listALl();
    UpdateGarageDTO updateGarage(Long id, Garage updatedGarage);

}
