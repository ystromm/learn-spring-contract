package com.github.ystromm.learn_spring_contract.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { FrontEndMain.class })
public class SchedulePageTest {

    @Autowired
    WebApplicationContext webApplicationContext;
    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void should_contain_event_description() throws IOException {
        final HtmlPage schedulePage = webClient.getPage("http://localhost:8080");
        assertThat(schedulePage.getElementsByIdAndOrName("event_description")).hasSize(1);
    }
}
