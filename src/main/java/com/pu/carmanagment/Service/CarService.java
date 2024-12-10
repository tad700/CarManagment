package com.pu.carmanagment.Service;

import com.pu.carmanagment.Entity.Car;

import java.util.List;


public interface CarService {
    Car findCarById(Long id);
    Car addCar(Car car);

    void deleteCar(Long id);
    List<Car> listAll();

    Car updateCar(Long id, Car updatedCar);

}
