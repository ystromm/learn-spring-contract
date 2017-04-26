package com.github.ystromm.learn_spring_contract.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndMain {
    public static void main(String[] args) {
        new ObjectMapper().registerModule(new JavaTimeModule());
        SpringApplication.run(BackEndMain.class, args);
    }
}
