package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3002")
@RequestMapping("garages")
public class GarageController {

    GarageService garageService;

            @Autowired
    GarageController(GarageService garageService){
        this.garageService = garageService;
            }
            @GetMapping("{id}")
            public ResponseEntity<ResponseGarageDTO> getGarage(@PathVariable Long id){
                return new ResponseEntity<>(garageService.findGarageById(id), HttpStatus.OK);
            }
            @GetMapping
            public ResponseEntity<List<ResponseGarageDTO>> getAll(){
                return new ResponseEntity<>(garageService.listALl(),HttpStatus.OK);
            }
            @PostMapping
            public ResponseEntity<CreateGarageDTO> addGarage(@RequestBody CreateGarageDTO garage){
             return new ResponseEntity<>(garageService.createGarage(garage),HttpStatus.CREATED);
            }
    @PutMapping("{id}")
    public ResponseEntity<UpdateGarageDTO> updateGarage(@PathVariable Long id, @RequestBody Garage garage){
                UpdateGarageDTO garage1 = garageService.updateGarage(id,garage);
                return ResponseEntity.ok(garage1);
    }
    @DeleteMapping("{id}")
    public void deleteGarage(Long id){
                garageService.deleteGarage(id);
    }
}
