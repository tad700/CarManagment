package com.pu.carmanagment.Mapper;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Entity.Car;

public class CarMapper {


        public static CreateCarDTO mapToCreateCarDTO(Car car) {
            return new CreateCarDTO(
                    car.getId(),
                    car.getMake(),
                    car.getModel(),
                    car.getProductionYear(),
                    car.getLicensePlate(),
                    car.getGarages()
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

    public static Car mapToCar(CreateCarDTO updateCarDto) {
        return new Car(
                updateCarDto.getId(),
                updateCarDto.getMake(),
                updateCarDto.getModel(),
                updateCarDto.getProductionYear(),
                updateCarDto.getLicensePlate(),
                updateCarDto.getGarageIds()
        );
    }
}
