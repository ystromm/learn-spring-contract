package com.github.ystromm.learn_spring_contract.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FrontEndMain.class})
@AutoConfigureStubRunner(workOffline = true, ids = "com.github.ystromm.learn_spring_contract:backend:+:stubs:8081")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class DetailPageTest {

    @Autowired
    private MockMvcWebClientBuilder mockMvcWebClientBuilder;
    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = mockMvcWebClientBuilder.build();
    }

    @Test
    public void should_have_description() throws IOException {
        assertThat(webClient.<HtmlPage>getPage("/1").getElementById("event_description").getTextContent()).isEqualTo("State of the Nation");
    }

    @Test
    public void should_have_location() throws IOException {
        assertThat(webClient.<HtmlPage>getPage("/1").getElementById("event_location").getTextContent()).isEqualTo("Adelsö");
    }

}
