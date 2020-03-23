package com.javing.asclepius.services;

import com.javing.asclepius.repositories.LocationsRepository;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.javing.asclepius.domain.Location.location;

@AllArgsConstructor
@Service
public class LocationsManagementService {

    private final CoordinatesFindingService coordinatesFindingService;
    private final LocationsRepository locationsRepository;

    public Try<UUID> newLocation(String locationType, String address) {

        return locationsRepository.newLocation(location(coordinatesFindingService
                .findCoordinatesFor(address), locationType));
    }
}
