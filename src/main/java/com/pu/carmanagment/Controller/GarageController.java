package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Service.GarageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("garages")
public class GarageController {

    GarageService garageService;

    @Autowired
    GarageController(GarageService garageService) {
        this.garageService = garageService;
    }


    @GetMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")

    public ResponseEntity<ResponseGarageDTO> getGarage(@PathVariable Long id) {
        return new ResponseEntity<>(garageService.findGarageById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")

    public ResponseEntity<List<ResponseGarageDTO>> getAll() {
        return new ResponseEntity<>(garageService.listALl(), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")

    public ResponseEntity<CreateGarageDTO> addGarage(@RequestBody CreateGarageDTO garage) {
        return new ResponseEntity<>(garageService.createGarage(garage), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<UpdateGarageDTO> updateGarage(@PathVariable Long id, @RequestBody @Valid UpdateGarageDTO garage) {
        UpdateGarageDTO garage1 = garageService.updateGarage(id, garage);
        return ResponseEntity.ok(garage1);


    }


    @DeleteMapping("{id}")
    @Operation(summary = "Delete garage", description = "Deletes garage from the database by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource Not Found")
    })
    public void deleteGarage(@PathVariable Long id) {
        garageService.deleteGarage(id);
    }
}
