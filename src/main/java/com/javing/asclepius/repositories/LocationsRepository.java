package com.javing.asclepius.repositories;

import com.javing.asclepius.domain.Coordinates;
import com.javing.asclepius.domain.Location;
import com.javing.asclepius.domain.Person;
import com.javing.asclepius.tables.Locations;
import com.javing.asclepius.tables.records.LocationsRecord;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

import static com.javing.asclepius.tables.Locations.LOCATIONS;

@AllArgsConstructor
@Repository
public class LocationsRepository {

    private final DSLContext dslContext;

    public Try<Integer> newLocation(final Location location) {

        Coordinates coordinates = location.getCoordinates();

        return Try.of(() -> dslContext.insertInto(LOCATIONS, LOCATIONS.LATITUDE, LOCATIONS.LONGITUDE, LOCATIONS.LOCATION_TYPE)
                .values(BigDecimal.valueOf(coordinates.getLatitude()),
                        BigDecimal.valueOf(coordinates.getLongitude()),
                        location.getType())
                .returning(LOCATIONS.LOCATION_PK)
                .fetchOne().getValue(LOCATIONS.LOCATION_PK));
    }

    public Try<Option<Location>> get(UUID uuid) {
        return null;
    }

    public Try<UUID> update(Location location) {
        return null;
    }

}
