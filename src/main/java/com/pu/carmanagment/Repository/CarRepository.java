package com.pu.carmanagment.Repository;

import com.pu.carmanagment.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findCarById(Long id);

}
