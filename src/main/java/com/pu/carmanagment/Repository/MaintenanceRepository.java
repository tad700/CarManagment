package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}
