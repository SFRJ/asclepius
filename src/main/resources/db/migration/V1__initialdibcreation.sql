-- 0) Run docker-compose up -d to init the postgres container
-- 1) Create the database with: psql -h localhost -p 54320 -U postgres -c "create database asclepiusdb;" (Use drop database command if needed)
-- 2) Perform a migration with: ./gradlew flywayMigrate -i <-This command on the terminal will trigger the migration
-- 3) Connect to the docker container that runs the database with: docker exec -it 658ce32b912e /bin/bash
-- 4) Check that the database exists with \list
-- 5) Connect to the database with: psql -U postgres asclepiusdb
-- 6) Check that the tables are created with \dt
-- 7) use the alias 'g' so that the build triggers the Jooq code generation

CREATE TABLE SURVEYS(
    survey_pk SERIAL PRIMARY KEY,
    latitude TEXT,
    longitude TEXT,
    ip TEXT,
    age INTEGER,
    sex TEXT,
    status TEXT,
    chronic BOOLEAN,
    isolating BOOLEAN,
    date_time TIMESTAMP
);
