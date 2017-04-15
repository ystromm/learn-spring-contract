package com.github.ystromm.learn_spring_contract.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {FrontEndMain.class})
@AutoConfigureStubRunner(workOffline = true, ids = "com.github.ystrom.learn_spring_contract:backend:+:stubs:8081")
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
        assertThat(schedulePage.getElementsByIdAndOrName("event_description")).hasSize(3);
    }

    @Test
    public void should_have_links() throws IOException {
        final HtmlPage schedulePage = webClient.getPage("http://localhost:8080");
        assertThat(schedulePage.getAnchors()).extracting(HtmlAnchor::getHrefAttribute).contains("/event/1", "/event/2", "/event/3");
    }


    @Test
    public void should_contain_descriptions() throws IOException {
        final HtmlPage schedulePage = webClient.getPage("http://localhost:8080");
        assertThat(schedulePage.getElementsByIdAndOrName("event_description")).extracting(DomNode::getTextContent)
                .contains("Att bygga en speldator",
                        "Konsumentdrivna kontraktstester",
                        "State of the Nation");
    }

    @Test
    public void should_contain_speakers() throws IOException {
        final HtmlPage schedulePage = webClient.getPage("http://localhost:8080");
        assertThat(schedulePage.getElementsByIdAndOrName("event_speaker")).extracting(DomNode::getTextContent)
                .contains("Martin Carlsson",
                        "Fredrik Löfgren",
                        "Johan Malmliden");
    }

}
