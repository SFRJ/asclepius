package com.javing.asclepius.repositories;

import com.javing.asclepius.domain.IpAddress;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import static com.javing.asclepius.tables.Locations.LOCATIONS;

@AllArgsConstructor
@Repository
public class LocationsRepository {

    private final DSLContext dslContext;

    public Try<String> newLocation(final IpAddress ipAddress) {

        return Try.of(() -> dslContext.insertInto(LOCATIONS, LOCATIONS.LATITUDE, LOCATIONS.LONGITUDE)
                .values(ipAddress.getLatitude(),
                        ipAddress.getLongitude())
                .returning(LOCATIONS.LOCATION_PK)
                .fetchOne().getValue(LOCATIONS.LOCATION_PK).toString());
    }


}
