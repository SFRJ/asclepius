package com.javing.asclepius.services;

import com.javing.asclepius.domain.Coordinates;
import com.javing.asclepius.domain.SurveyAnswers;
import com.javing.asclepius.repositories.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DataManagementService {

    private final IpGeolocationService ipGeolocationService;
    private final DataRepository dataRepository;

    public String newSurvey(String clientIp, SurveyAnswers surveyAnswers) {

        return dataRepository.newSurvey(surveyAnswers, ipGeolocationService.find(clientIp)
                .getOrElseThrow(() -> new RuntimeException("Unable to get IP details")))
                .getOrElseThrow(() -> new RuntimeException("Unable to save to database"));
    }

    public List<Coordinates> allCoordinates() {
        return dataRepository.all();
    }
}
