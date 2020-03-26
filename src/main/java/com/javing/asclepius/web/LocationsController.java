package com.javing.asclepius.web;

import com.javing.asclepius.domain.SurveyAnswers;
import com.javing.asclepius.services.SurveyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import static com.javing.asclepius.services.IpFinder.getClientIp;

@RestController
@RequiredArgsConstructor
public class LocationsController {

    private final SurveyManagementService surveyManagementService;

    @RequestMapping(value = "/locations/new", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> newLocation(@RequestBody SurveyAnswers surveyAnswers, HttpServletRequest request) {

        String ipAddress = getClientIp((request));
        if(ipAddress == null || ipAddress.equals("0:0:0:0:0:0:0:1"))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .body(surveyManagementService
                        .newSurvey(ipAddress, surveyAnswers));
    }
}
