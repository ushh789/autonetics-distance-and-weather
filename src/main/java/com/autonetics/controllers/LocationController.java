package com.autonetics.controllers;

import com.autonetics.mappers.LocationMapper;
import com.autonetics.models.response.LocationDto;
import com.autonetics.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @GetMapping
    public ResponseEntity<List<LocationDto>> getLocations(@RequestHeader("latitude") BigDecimal latitude, @RequestHeader("longitude") BigDecimal longitude) {
        return ResponseEntity.ok(
                locationService.findLocationsWithin100Meters(latitude, longitude)
                        .stream()
                        .map(locationMapper::toDto)
                        .collect(java.util.stream.Collectors.toList())
        );
    }

}
