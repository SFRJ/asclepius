package com.javing.asclepius.web;

import com.javing.asclepius.domain.Coordinates;
import com.javing.asclepius.domain.SurveyAnswers;
import com.javing.asclepius.services.AnswersValidationService;
import com.javing.asclepius.services.DataManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final DataManagementService dataManagementService;
    private final AnswersValidationService answersValidationService;

    @RequestMapping(value = "/surveys/new", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> newSurvey(@RequestBody SurveyAnswers surveyAnswers, HttpServletRequest request) {

        if(answersValidationService.isValid(surveyAnswers)) {
            return ResponseEntity.ok()
                    .body(dataManagementService
                            .newSurvey(request.getRemoteAddr(), surveyAnswers));
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/coordinates", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<Coordinates>> allCoordinates() {
        return ResponseEntity.ok().body(dataManagementService.allCoordinates());
    }
}
