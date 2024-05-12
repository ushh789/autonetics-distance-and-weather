package com.autonetics.services.implementation;

import com.autonetics.models.entity.Location;
import com.autonetics.repositories.LocationRepository;
import com.autonetics.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public List<Location> findLocationsWithin100Meters(BigDecimal latitude, BigDecimal longitude) {
        if ((latitude.compareTo(BigDecimal.valueOf(-90)) < 0) || (latitude.compareTo(BigDecimal.valueOf(90)) > 0) ||
                (longitude.compareTo(BigDecimal.valueOf(-180)) < 0) || (longitude.compareTo(BigDecimal.valueOf(180)) > 0)) {
            throw new IllegalArgumentException("Invalid latitude or longitude");
        }
        return locationRepository.findLocationsWithin100Meters(latitude, longitude);
    }
}
