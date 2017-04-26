package com.github.ystromm.learn_spring_contract.frontend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = FrontEndMain.class)
public class FrontEndMain {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SpringApplication.run(FrontEndMain.class, args);
    }
}
