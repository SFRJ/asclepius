package com.javing.asclepius.domain;

import lombok.Data;

@Data
public class IpAddress {

    private String ip;
    private String country;
    private String region;
    private String city;
    private String latitude;
    private String longitude;
    private String isp;
}

