package com.javing.asclepius.web;

import com.javing.asclepius.domain.exceptions.LocationCreationException;
import com.javing.asclepius.services.LocationsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LocationsController {

    private final LocationsManagementService locationsManagementService;

    @RequestMapping(value = "/locations/new", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<UUID> newLocation(@RequestBody NewLocationRequest newLocationRequest) {

        return ResponseEntity.ok().body(locationsManagementService
                .newLocation(newLocationRequest.getLocationType(), newLocationRequest.getAddress())
                .getOrElseThrow(() -> new LocationCreationException("Unable to create Location")));
    }
}
