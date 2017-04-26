package com.github.ystromm.learn_spring_contract.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class BackEndMain {
    public static void main(String[] args) {
        SpringApplication.run(BackEndMain.class, args);
    }

    @Bean
    public Jackson2ObjectMapperBuilder getJacksonObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modulesToInstall(JavaTimeModule.class);
    }
}
