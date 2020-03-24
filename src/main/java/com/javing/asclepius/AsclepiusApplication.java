package com.javing.asclepius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AsclepiusApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsclepiusApplication.class, args);
    }

}
