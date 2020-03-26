package com.javing.asclepius.services;

import com.javing.asclepius.domain.SurveyAnswers;
import com.javing.asclepius.repositories.SurveysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SurveyManagementService {

    private final IpGeolocationService ipGeolocationService;
    private final SurveysRepository surveysRepository;

    public String newSurvey(String clientIp, SurveyAnswers surveyAnswers) {

        return surveysRepository.newSurvey(surveyAnswers, ipGeolocationService.find(clientIp)
                .getOrElseThrow(() -> new RuntimeException("Unable to get IP details")))
                .getOrElseThrow(() -> new RuntimeException("Unable to save to database"));
    }
}
