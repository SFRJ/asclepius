package com.javing.asclepius.domain;

import lombok.Data;

@Data
public final class SurveyAnswers {

    private final Integer age;
    private final String sex;
    private final String status;
    private final Boolean chronic;
    private final Boolean keyworker;

}
