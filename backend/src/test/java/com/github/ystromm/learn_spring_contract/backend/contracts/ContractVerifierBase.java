package com.github.ystromm.learn_spring_contract.backend.contracts;

import com.github.ystromm.learn_spring_contract.backend.controller.EventController;
import com.github.ystromm.learn_spring_contract.backend.repository.EventRepository;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;

@Ignore
public class ContractVerifierBase {

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(new EventController(new EventRepository()));;
    }
}