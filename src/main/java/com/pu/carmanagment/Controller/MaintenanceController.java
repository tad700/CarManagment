package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Service.MaintenanceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/maintenance")
@AllArgsConstructor
public class MaintenanceController {
    MaintenanceService maintenanceService;

    @GetMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<ResponseMaintenanceDTO> getMaintenance(@PathVariable Long id) {
        return new ResponseEntity<>(maintenanceService.findGarageById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")

    public ResponseEntity<List<ResponseMaintenanceDTO>> listAll() {
        return new ResponseEntity<>(maintenanceService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")

    public ResponseEntity<CreateMaintenanceDTO> createMaintenance(@RequestBody CreateMaintenanceDTO maintenance) {
        return new ResponseEntity<>(maintenanceService.createMaintenance(maintenance.getCarId(), maintenance.getGarageId(), maintenance), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<UpdateMaintenanceDTO> updateMaintenance(@PathVariable Long id, @RequestBody @Valid UpdateMaintenanceDTO updateMaintenanceDTO) {
        UpdateMaintenanceDTO maintenance1 = maintenanceService.updateMaintenance(id, updateMaintenanceDTO);
        return ResponseEntity.ok(maintenance1);

    }

    @DeleteMapping("{id}")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Resource Not Found")

    public ResponseEntity<String> deleteMaintenance(Long id) {
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<>("Succesfully Deleted maintenance with id" + id, HttpStatus.OK);
    }

}
