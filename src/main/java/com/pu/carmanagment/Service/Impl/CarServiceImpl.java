package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Entity.Car;

import com.pu.carmanagment.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Car addCar(Car car) {
        Car savedCar = new Car(car.getId(),
                car.getMake(), car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                car.getGarages());

        carRepository.save(savedCar);
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
    public Car updateCar(Long id, Car updatedCar) {
        Car car = carRepository.findCarById(id);
        car.setMake(updatedCar.getMake());
        car.setModel(updatedCar.getModel());
        car.setProductionYear(updatedCar.getProductionYear());
        car.setLicensePlate(car.getLicensePlate());
        car.setGarages(updatedCar.getGarages());

        return carRepository.save(car);
    }

}
