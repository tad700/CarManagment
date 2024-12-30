package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByMake(String make);

    @Query("SELECT c FROM Car c JOIN c.garages g WHERE g.id = :garageId")
    List<Car> findByGarageId(@Param("garageId") Integer garageId);


    @Query("SELECT c FROM Car c WHERE c.productionYear BETWEEN :startYear AND :endYear")
    List<Car> findByProductionYearBetween(@Param("startYear") LocalDate startYear, @Param("endYear") LocalDate endYear);

}
