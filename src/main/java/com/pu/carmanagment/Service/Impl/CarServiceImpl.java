package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Entity.Car;

import com.pu.carmanagment.Mapper.CarMapper;
import com.pu.carmanagment.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.pu.carmanagment.Service.CarService;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

   private CarRepository carRepository;

    @Override
    public Car findCarById(Long id) {
        return carRepository.findCarById(id);


    }

    @Override
    public CreateCarDTO addCar(CreateCarDTO car) {
        CreateCarDTO savedCar = new CreateCarDTO(car.getId(),
                car.getMake(), car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                car.getGarageIds());
        Car carToSave = CarMapper.mapToCar(savedCar);
        carRepository.save(carToSave);
        return savedCar;


    }

    @Override
    public void deleteCar(Long id) {
        Car carToDelete = carRepository.findCarById(id);
        carRepository.delete(carToDelete);
    }

    @Override
    public List<Car> listAll() {
        return carRepository.findAll();
    }

    @Override
    public UpdateCarDTO updateCar(Long id, UpdateCarDTO updatedCar) {
        Car car = carRepository.findCarById(id);
        car.setMake(updatedCar.getMake());
        car.setModel(updatedCar.getModel());
        car.setProductionYear(updatedCar.getProductionYear());
        car.setLicensePlate(car.getLicensePlate());
        car.setGarages(updatedCar.getGarageIds());
        carRepository.save(car);
        return CarMapper.mapToUpdateCarDTO(car);
    }


}
