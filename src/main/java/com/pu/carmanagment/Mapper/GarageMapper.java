package com.pu.carmanagment.Mapper;


import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Car;
import com.pu.carmanagment.Entity.Garage;

public class GarageMapper {

    public static CreateGarageDTO mapToCreateGarageDTO(Garage garage) {
        return new CreateGarageDTO(
                garage.getGarageid(),
                garage.getName(),
                garage.getLocation(),
                garage.getCity(),
                garage.getCapacity()
        );
    }
    public static UpdateGarageDTO mapToUpdateGarageDTO(Garage garage) {
        return new UpdateGarageDTO(
                garage.getGarageid(),
                garage.getName(),
                garage.getLocation(),
                garage.getCity(),
                garage.getCapacity()
                );
    }
    public static ResponseGarageDTO mapToResponseGarageDTO(Garage garage) {
        return new ResponseGarageDTO(
                garage.getGarageid(),
                garage.getName(),
                garage.getLocation(),
                garage.getCity(),
                garage.getCapacity()
        );
    }
    public static Garage mapToGarage(CreateGarageDTO createGarageDTO) {
        return new Garage(
                createGarageDTO.getGarageid(),
                createGarageDTO.getName(),
                createGarageDTO.getLocation(),
                createGarageDTO.getCity(),
                createGarageDTO.getCapacity()
        );
    }
}
