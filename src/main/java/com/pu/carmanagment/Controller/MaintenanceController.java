package com.pu.carmanagment.Controller;

import com.pu.carmanagment.Dto.MaintenanceDTOs.CreateMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.ResponseMaintenanceDTO;
import com.pu.carmanagment.Dto.MaintenanceDTOs.UpdateMaintenanceDTO;
import com.pu.carmanagment.Service.MaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3002")
@RequestMapping("/maintenance")
@AllArgsConstructor
public class MaintenanceController {
    MaintenanceService maintenanceService;
    @GetMapping("{id}")
    public ResponseEntity<ResponseMaintenanceDTO> getMaintenance (@PathVariable Long id){
        return new ResponseEntity<>(maintenanceService.findGarageById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ResponseMaintenanceDTO>> listAll(){
        return new ResponseEntity<>(maintenanceService.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateMaintenanceDTO> createMaintenance(@RequestBody CreateMaintenanceDTO maintenance){
        return new ResponseEntity<>(maintenanceService.createMaintenance(maintenance),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<UpdateMaintenanceDTO> updateMaintenance(@PathVariable Long id,UpdateMaintenanceDTO updateMaintenanceDTO){
       UpdateMaintenanceDTO updated =  maintenanceService.updateMaintenance(id,updateMaintenanceDTO);
        return ResponseEntity.ok(updated);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMaintenance(Long id){
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<>("Succesfully Deleted maintenance with id" + id,HttpStatus.OK);
    }

}
