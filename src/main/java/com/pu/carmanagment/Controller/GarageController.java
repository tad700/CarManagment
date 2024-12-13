package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.GarageDTOs.CreateGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.ResponseGarageDTO;
import com.pu.carmanagment.Dto.GarageDTOs.UpdateGarageDTO;
import com.pu.carmanagment.Entity.Garage;
import com.pu.carmanagment.Exception.ResourceNotFoundException;
import com.pu.carmanagment.Service.GarageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    GarageController(GarageService garageService){
        this.garageService = garageService;
            }

            @GetMapping("{id}")
            @Operation(summary = "Get garage by id", description = "Get garage by id")
            @ApiResponses(value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
            })
            public ResponseEntity<ResponseGarageDTO> getGarage(@PathVariable Long id){
                return new ResponseEntity<>(garageService.findGarageById(id), HttpStatus.OK);
            }

            @GetMapping
            @Operation(summary = "List garages", description = "lists all garages from the database")
            @ApiResponses(value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
            })
            public ResponseEntity<List<ResponseGarageDTO>> getAll(){
                return new ResponseEntity<>(garageService.listALl(),HttpStatus.OK);
            }

            @PostMapping
            @Operation(summary = "Create garage", description = "Creates garage.")
            @ApiResponses(value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request"),
                    @ApiResponse(responseCode = "404", description = "Resource Not Found")
            })
            public ResponseEntity<CreateGarageDTO> addGarage(@RequestBody CreateGarageDTO garage){
             return new ResponseEntity<>(garageService.createGarage(garage),HttpStatus.OK);
            }

    @PutMapping("{id}")
    @Operation(summary = "Update an existing garage", description = "Updates the details of a garage by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource Not Found")
    })
    public ResponseEntity<UpdateGarageDTO> updateGarage(
            @PathVariable Long id,
            @RequestBody @Valid UpdateGarageDTO garage) {
        try {
            UpdateGarageDTO garage1 = garageService.updateGarage(id, garage);
            return ResponseEntity.ok(garage1);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




    @DeleteMapping("{id}")
    @Operation(summary = "Delete garage", description = "Deletes garage from the database by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource Not Found")
    })
            public void deleteGarage(@PathVariable  Long id){
                garageService.deleteGarage(id);
    }
}
