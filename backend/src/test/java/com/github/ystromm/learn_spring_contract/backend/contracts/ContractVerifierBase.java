package com.github.ystromm.learn_spring_contract.backend.contracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.ystromm.learn_spring_contract.backend.controller.EventController;
import com.github.ystromm.learn_spring_contract.backend.repository.EventRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.mapper.factory.Jackson2ObjectMapperFactory;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.Before;
import org.junit.Ignore;

import static com.jayway.restassured.config.ObjectMapperConfig.objectMapperConfig;

@Ignore
public class ContractVerifierBase {

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.config = RestAssuredMockMvcConfig.config().objectMapperConfig(
                objectMapperConfig().jackson2ObjectMapperFactory(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Class cls, String charset) {
                System.err.println("=============================================");
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                return objectMapper;
            }
        }));
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(
                objectMapperConfig().jackson2ObjectMapperFactory(new Jackson2ObjectMapperFactory() {

                    @SuppressWarnings("rawtypes")
                    @Override
                    public ObjectMapper create(Class cls, String charset) {
                        System.err.println("=============================================");

                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.registerModule(new JavaTimeModule());
                        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                        return objectMapper;
                    }
                }));


        RestAssuredMockMvc.standaloneSetup(new EventController(new EventRepository()));
    }
}