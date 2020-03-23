package com.javing.asclepius.config;

import com.javing.asclepius.repositories.LocationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RepositoryConfiguration {

    @Bean
    LocationsRepository locationsRepository() {
        return null;
    }

}
