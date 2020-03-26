package com.javing.asclepius.web;

import com.javing.asclepius.services.LocationsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

import static com.javing.asclepius.services.IpFinder.getClientIp;
import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;

@RestController
@RequiredArgsConstructor
public class LocationsController {

    private final LocationsManagementService locationsManagementService;

    @RequestMapping(value = "/locations/new", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> newLocation(HttpServletRequest request) {
        String ipAddress = getClientIp((request));

        if(ipAddress == null || ipAddress.equals("0:0:0:0:0:0:0:1"))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .body(locationsManagementService
                        .newLocation(ipAddress));
    }
}
