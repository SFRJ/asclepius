package com.javing.asclepius.repositories;

import com.javing.asclepius.domain.Location;
import com.javing.asclepius.domain.Person;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class LocationsRepository {

    public Try<UUID> newLocation(Location location) {
        return null;
    }

    public Try<Option<Location>> get(UUID uuid) {
        return null;
    }

    public Try<UUID> update(Location location) {
        return null;
    }

}
