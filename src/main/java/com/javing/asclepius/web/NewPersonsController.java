package com.javing.asclepius.web;

import com.javing.asclepius.domain.exceptions.LocationCreationException;
import com.javing.asclepius.services.PersonsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.javing.asclepius.domain.Person.person;

@RestController
@RequiredArgsConstructor
public class NewPersonsController {

    private final PersonsManagementService personsManagementService;

    @RequestMapping(value = "/persons/new", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<UUID> newLocation(@RequestBody NewPersonRequest request) {

        return ResponseEntity.ok().body(personsManagementService
                .newPerson(request.getLocationId(), person(request.getAge(), request.getSex(), request.isInfected(),
                        request.isAlive(), request.isChronic()))
                .getOrElseThrow(() -> new LocationCreationException("Unable to create person")));
    }
}
