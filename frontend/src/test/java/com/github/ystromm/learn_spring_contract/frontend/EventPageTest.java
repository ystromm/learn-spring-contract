package com.github.ystromm.learn_spring_contract.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.ystromm.learn_spring_contract.frontend.controller.EventController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FrontEndMain.class})
@AutoConfigureStubRunner(workOffline = true, ids = "com.github.ystrom.learn_spring_contract:backend:0.0.1-SNAPSHOT:stubs:8081")
@WebMvcTest(controllers = EventController.class)
@AutoConfigureWebClient
public class EventPageTest {

    @Autowired
    private MockMvcWebClientBuilder mockMvcWebClientBuilder;
    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = mockMvcWebClientBuilder.build();
    }

    @Test
    public void should_have_description() throws IOException {
        final HtmlPage eventPage = webClient.getPage("http://localhost:8080/event/1");
        assertThat(eventPage.getElementById("event_description")).isEqualTo("State of the Nation");
    }
}
