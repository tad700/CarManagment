package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage,Integer> {

}
