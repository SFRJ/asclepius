package com.javing.asclepius.repositories;

import com.javing.asclepius.domain.Coordinates;
import com.javing.asclepius.domain.IpAddress;
import com.javing.asclepius.domain.SurveyAnswers;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.javing.asclepius.tables.Surveys.SURVEYS;
import static java.sql.Timestamp.valueOf;

@AllArgsConstructor
@Repository
public class DataRepository {

    private final DSLContext dslContext;

    public Try<String> newSurvey(SurveyAnswers answers, final IpAddress address) {
        return Try.of(() -> dslContext.insertInto(SURVEYS, SURVEYS.LATITUDE, SURVEYS.LONGITUDE,
                SURVEYS.IP, SURVEYS.AGE, SURVEYS.SEX, SURVEYS.STATUS, SURVEYS.CHRONIC, SURVEYS.ISOLATING, SURVEYS.DATE_TIME)
                .values(address.getLatitude(), address.getLongitude(), address.getIp(), answers.getAge(),
                        answers.getSex(), answers.getStatus(), answers.isChronic(), answers.isIsolating(), valueOf(LocalDateTime.now()))
                .returning(SURVEYS.SURVEY_PK)
                .fetchOne().getValue(SURVEYS.SURVEY_PK).toString());
    }

    public List<Coordinates> all() {
        return dslContext.select(SURVEYS.LATITUDE, SURVEYS.LONGITUDE)
                .from(SURVEYS).fetchInto(Coordinates.class);
    }
}
