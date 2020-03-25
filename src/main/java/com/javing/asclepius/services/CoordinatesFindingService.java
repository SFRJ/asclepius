package com.javing.asclepius.services;

import com.javing.asclepius.domain.Coordinates;
import org.springframework.stereotype.Service;

import static kong.unirest.Unirest.get;

@Service
public class CoordinatesFindingService {

    public Coordinates findCoordinatesFor(String address) {

        //GET 28+Bisley+Cl,+Worcester+Park+KT4+8PN

        String responseAsString = get(String.format("https://www.google.com/maps/place/%s", address
                .replace(" ", "+")))
                .asString().getBody();

        int coordinateStart = responseAsString.indexOf("nter=");
        int coordinateEnd = responseAsString.indexOf("&amp;zoom");

        String substring = responseAsString.substring(coordinateStart, coordinateEnd);

        return new Coordinates(111D, 222D);
    }
}
