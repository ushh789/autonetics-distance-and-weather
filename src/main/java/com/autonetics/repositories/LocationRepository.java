package com.autonetics.repositories;

import com.autonetics.models.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "SELECT l FROM Location l WHERE " +
            "(6371 * acos(cos(radians(:latitude))" +
            " * cos(radians(l.latitude)) * cos(radians(l.longitude)" +
            " - radians(:longitude)) + sin(radians(:latitude))" +
            " * sin(radians(l.latitude)))) < 0.1")
    List<Location> findLocationsWithin100Meters(@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude);
}