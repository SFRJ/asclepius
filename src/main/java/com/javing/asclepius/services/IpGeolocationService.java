package com.javing.asclepius.services;

import com.javing.asclepius.domain.IpAddress;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static kong.unirest.Unirest.get;

@Service
public class IpGeolocationService {

    public Try<IpAddress> find(String clientIp) {

        return Try.of(() -> get(format("http://free.ipwhois.io/json/%s", clientIp))
                .header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36")
                        .asObject(IpAddress.class).getBody()
        );
    }
}

