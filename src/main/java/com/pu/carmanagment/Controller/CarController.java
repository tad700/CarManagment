package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Entity.Car;

import com.pu.carmanagment.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    CarService carService;
    @Autowired
    CarController(CarService carService){
        this.carService = carService;
    }


    @GetMapping("/{id}")
    public Car getCarById(@PathVariable  Long id){
        return carService.findCarById(id);
    }
    @PostMapping("add")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car car1 = carService.addCar(car);
        return new ResponseEntity<>(car1, HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
    @GetMapping("listAll")
    public ResponseEntity<List> listAll(){
        List<Car> cars = carService.listAll();
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Car> updateGarage(@PathVariable Long id, @RequestBody Car car){
        Car car1 = carService.updateCar(id,car);
        return ResponseEntity.ok(car);
    }

}
