package com.github.ystromm.learn_spring_contract.frontend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FrontEndMain.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(workOffline = true, ids = "com.github.ystromm.learn_spring_contract:backend:+:8081")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class DetailPageMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_should_have_description() throws Exception {
        mockMvc.perform(get("/1").accept(MediaType.TEXT_HTML)).andExpect(status().isOk());
    }

    @Test
    public void get_nonExisting_should_return_movedTemporarily() throws Exception {
        mockMvc.perform(get("/4711").accept(MediaType.TEXT_HTML)).andExpect(status().isMovedTemporarily());
    }
}
