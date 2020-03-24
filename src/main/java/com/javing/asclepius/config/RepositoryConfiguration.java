package com.javing.asclepius.config;

import com.javing.asclepius.repositories.LocationsRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class RepositoryConfiguration {

    @Bean
    LocationsRepository locationsRepository(@Autowired final DSLContext dslContext) {
        return new LocationsRepository(dslContext);
    }

}
