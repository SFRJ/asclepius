package com.javing.asclepius.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class NewPersonRequest {

    private final UUID locationId;
    private final Integer age;
    private final String sex;
    private final boolean infected;
    private final boolean alive;
    private final boolean chronic;

}
