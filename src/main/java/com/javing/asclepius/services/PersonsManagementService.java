package com.javing.asclepius.services;

import com.javing.asclepius.domain.Person;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class PersonsManagementService {

    public Try<UUID> newPerson(UUID locationId, Person person) {

        return null;

    }
}
