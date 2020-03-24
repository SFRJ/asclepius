package com.javing.asclepius.services;

import com.javing.asclepius.domain.Coordinates;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesFindingService {

    public Coordinates findCoordinatesFor(String address) {
        return new Coordinates(111D, 222D);
    }
}
