package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/garage")
public class GarageController {

    GarageService garageService;

            @Autowired
    GarageController(GarageService garageService){
        this.garageService = garageService;
            }
            @GetMapping("{id}")
            public ResponseEntity<Garage> getGarage(@PathVariable Long id){
                return new ResponseEntity<>(garageService.findGarageById(id), HttpStatus.OK);
            }
            @GetMapping("listAll")
            public ResponseEntity<List<Garage>> getAll(){
                return new ResponseEntity<>(garageService.listALl(),HttpStatus.OK);
            }
            @PostMapping("add")
            public ResponseEntity<Garage> addGarage(@RequestBody Garage garage){
             return new ResponseEntity<>(garageService.addGarage(garage),HttpStatus.CREATED);
            }
    @PutMapping("update/{id}")
    public ResponseEntity<Garage> updateGarage(@PathVariable Long id,@RequestBody Garage garage){
                Garage garage1 = garageService.updateGarage(id,garage);
                return ResponseEntity.ok(garage1);
    }
    @DeleteMapping("delete/{id}")
    public void deleteGarage(Long id){
                garageService.deleteGarage(id);
    }
}
