package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;

import com.pu.carmanagment.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("cars")
public class CarController {

    CarService carService;
    @Autowired
    CarController(CarService carService){
        this.carService = carService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarDTO> getCarById(@PathVariable  Long id){

        return new ResponseEntity<>(carService.findCarById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateCarDTO> createCar(@RequestBody CreateCarDTO car){
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
    @GetMapping
    public ResponseEntity<List<ResponseCarDTO>> getAll(){
        return new ResponseEntity<>(carService.getAll(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<UpdateCarDTO> updateGarage(@PathVariable Long id, @RequestBody UpdateCarDTO car){
        UpdateCarDTO car1 = carService.updateCar(id,car);
        return ResponseEntity.ok(car);
    }

}
