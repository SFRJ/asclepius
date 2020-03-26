package com.javing.asclepius.domain;

import lombok.Data;

@Data
public final class SurveyAnswers {

    private final Integer age;
    private final String sex;
    private final String status;//I suspect im infected, I am feeling healthy, I was diagnosed covid-19
    private final boolean chronic;
    private final boolean keyWorker;
    private final boolean isIsolating;

}
