package com.javing.asclepius.services;

import com.javing.asclepius.repositories.LocationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LocationsManagementService {

    private final IpGeolocationService ipGeolocationService;
    private final LocationsRepository locationsRepository;

    public String newLocation(String clientIp) {


        return locationsRepository.newLocation(ipGeolocationService.find(clientIp)
                .getOrElseThrow(() -> new RuntimeException("Unable to get IP details")))
                .getOrElseThrow(() -> new RuntimeException("Unable to save to database"));
    }
}
