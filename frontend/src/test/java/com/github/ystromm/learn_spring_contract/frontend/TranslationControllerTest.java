package com.github.ystromm.learn_spring_contract.frontend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(workOffline = true, ids = "com.github.ystromm.learn_spring_contract:backend:+:8081")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class TranslationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_existing_should_return_ok() throws Exception {
        mockMvc.perform(get("/rest/handelse/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void get_ping_should_return_ok() throws Exception {
        mockMvc.perform(get("/rest/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }

    @Test
    public void get_existing_should_have_beskrivning() throws Exception {
        mockMvc.perform(get("/rest/handelse/1"))
                .andExpect(content().json("{beskrivning: \"State of the Nation\"}"));
    }

    @Test
    public void get_existing_should_have_talare() throws Exception {
        mockMvc.perform(get("/rest/handelse/1"))
                .andExpect(content().json("{talare: \"Johan Malmliden\"}"));
    }

    @Test
    public void get_nonExisting_should_redirect() throws Exception {
        mockMvc.perform(get("/4711"))
                .andExpect(status().is3xxRedirection());
    }
}
