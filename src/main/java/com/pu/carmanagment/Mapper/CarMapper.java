package com.pu.carmanagment.Mapper;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Entity.Car;
import com.pu.carmanagment.Entity.Garage;

import java.util.stream.Collectors;

public class CarMapper {


        public static CreateCarDTO mapToCreateCarDTO(Car car) {
            return new CreateCarDTO(
                    car.getId(),
                    car.getMake(),
                    car.getModel(),
                    car.getProductionYear(),
                    car.getLicensePlate(),
                    car.getGarages().stream().map(Garage::getId).collect(Collectors.toList())
            );
        }
    public static UpdateCarDTO mapToUpdateCarDTO(Car car) {
        return new UpdateCarDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                car.getGarages()
        );
    }
    public static ResponseCarDTO mapToResponseCarDTO(Car car) {
        return new ResponseCarDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                car.getGarages()
        );
    }

    public static Car mapToCar(ResponseCarDTO responseCarDTO) {
        return new Car(
                responseCarDTO.getId(),
                responseCarDTO.getMake(),
                responseCarDTO.getModel(),
                responseCarDTO.getProductionYear(),
                responseCarDTO.getLicensePlate(),
                responseCarDTO.getGarages()
        );
    }
}
