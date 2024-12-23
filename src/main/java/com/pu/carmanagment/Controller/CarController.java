package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.CarDTOs.CreateCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.ResponseCarDTO;
import com.pu.carmanagment.Dto.CarDTOs.UpdateCarDTO;
import com.pu.carmanagment.Service.CarService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cars")
public class CarController {

    CarService carService;

    @Autowired
    CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    public ResponseEntity<ResponseCarDTO> getCarById(@PathVariable int id) {

        return new ResponseEntity<>(carService.findCarById(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    public ResponseEntity<CreateCarDTO> createCar(@RequestBody @Valid CreateCarDTO car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<List<ResponseCarDTO>> getAll() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<UpdateCarDTO> updateGarage(@PathVariable int id, @Valid @RequestBody UpdateCarDTO car) {
        UpdateCarDTO car1 = carService.updateCar(id, car);
        return ResponseEntity.ok(car1);
    }

}
