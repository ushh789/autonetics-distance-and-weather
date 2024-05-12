package com.autonetics.services;

import com.autonetics.models.entity.Location;

import java.math.BigDecimal;
import java.util.List;

public interface LocationService {
    List<Location> findLocationsWithin100Meters(BigDecimal latitude, BigDecimal longitude);
}
