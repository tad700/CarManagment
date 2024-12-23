package com.pu.carmanagment.Service.Impl;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Entity.Car;

import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Mapper.CarMapper;
import com.pu.carmanagment.Repository.CarRepository;
import com.pu.carmanagment.Repository.GarageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.pu.carmanagment.Service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private GarageRepository garageRepository;

    @Override
    public ResponseCarDTO findCarById(int id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Car is not found with id: " + id));
        return CarMapper.mapToResponseCarDTO(car);


    }

    @Override
    public CreateCarDTO createCar(CreateCarDTO car) {
        Car savedCar = new Car();
        List<Integer> garageIds = car.getGarageIds();
        List<Garage> garages = new ArrayList<>();
        for(Integer id : garageIds){
            Garage garage = garageRepository.findById(id).orElseThrow(
                    ()-> new RuntimeException("Garage not found with id "+id)
            );
            garages.add(garage);
        }
        savedCar.setMake(car.getMake());
        savedCar.setModel(car.getModel());
        savedCar.setProductionYear(car.getProductionYear());
        savedCar.setLicensePlate(car.getLicensePlate());
        savedCar.setGarages(garages);


        carRepository.save(savedCar);


        return CarMapper.mapToCreateCarDTO(savedCar);


    }

    @Override
    public void deleteCar(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("car is not found with id"+id)
        );
        carRepository.delete(carToDelete);
    }

    @Override
    public List<ResponseCarDTO> getAll() {
        List<Car> cars = carRepository.findAll();

        return cars.stream()
                .map(CarMapper::mapToResponseCarDTO)
                .collect(Collectors.toList());

    }

    @Override
    public UpdateCarDTO updateCar(int id, UpdateCarDTO updatedCar) {
        Car car = carRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("car is not found with id"+id)
        );
        car.setMake(updatedCar.getMake());
        car.setModel(updatedCar.getModel());
        car.setProductionYear(updatedCar.getProductionYear());
        car.setLicensePlate(updatedCar.getLicensePlate());
        car.setGarages(updatedCar.getGarages());
        carRepository.save(car);
        return CarMapper.mapToUpdateCarDTO(car);
    }


}
