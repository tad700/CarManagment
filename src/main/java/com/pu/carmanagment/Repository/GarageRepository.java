package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository extends JpaRepository<Garage,Integer> {

    @Query("SELECT g FROM Garage g WHERE g.city = :city")
    List<Garage> findByCity(@Param("city") String city);

}
