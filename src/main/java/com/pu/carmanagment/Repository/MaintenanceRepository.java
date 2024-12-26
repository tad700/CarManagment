package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {

    @Query("SELECT m FROM Maintenance m WHERE m.garageId = :garageId AND m.scheduledDate BETWEEN :startDate AND :endDate")
    List<Maintenance> findByGarageIdAndDateRange(
            @Param("garageId") int garageId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
