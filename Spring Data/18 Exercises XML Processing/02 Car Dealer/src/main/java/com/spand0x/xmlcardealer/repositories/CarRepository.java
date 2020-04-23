package com.spand0x.xmlcardealer.repositories;

import com.spand0x.xmlcardealer.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car getCarByMakeAndModelAndTravelledDistance(String make, String model,long distance);
    List<Car> getAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
    List<Car> getAllByIdNotNull();
}
