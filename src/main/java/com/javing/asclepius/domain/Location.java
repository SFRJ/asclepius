package com.javing.asclepius.domain;

import lombok.Getter;

@Getter
public final class Location {

    private final Coordinates coordinates;
    private final String type;

    private Location(Coordinates coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public static Location location(Coordinates coordinates, String type) {
        return new Location(coordinates, type);
    }
}
