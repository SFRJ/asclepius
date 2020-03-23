package com.javing.asclepius.domain;

import lombok.Getter;

@Getter
public final class Person {

    private final Integer age;
    private final String sex;
    private final boolean infected;
    private final boolean alive;
    private final boolean chronic;

    private Person(Integer age, String sex, boolean infected, boolean alive, boolean chronic) {
        this.age = age;
        this.sex = sex;
        this.infected = infected;
        this.alive = alive;
        this.chronic = chronic;
    }

    public static Person person(Integer age, String sex, boolean infected, boolean alive, boolean chronic) {
        return new Person(age, sex, infected, alive, chronic);
    }
}
