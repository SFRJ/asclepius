package com.javing.asclepius.services;

import com.javing.asclepius.domain.SurveyAnswers;
import org.springframework.stereotype.Service;

@Service
public class AnswersValidationService {

    public Boolean isValid(SurveyAnswers answers) {

        return answers.getAge() != null &&
                answers.getIsChronic() != null &&
                answers.getIsIsolating() != null &&
                answers.getIsKeyWorker() != null &&
                answers.getSex() != null &&
                !answers.getSex().isEmpty() &&
                answers.getStatus() != null &&
                !answers.getStatus().isEmpty() &&
                answers.getAge() >= 0 &&
                answers.getAge() <= 120;
    }


}
