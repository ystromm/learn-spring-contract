package com.github.ystromm.learn_spring_contract.frontend.client;

import com.github.ystromm.learn_spring_contract.frontend.json.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Component
public class EventClient {

    public static final String BASE_URL = "http://localhost:";
    private final RestTemplate restTemplate;
    private final int port = 8081;

    @Autowired
    EventClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Collection<Event> getAll() {
        final ResponseEntity<Event[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/event", Event[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    public Optional<Event> get(int id) {
        try {
            final ResponseEntity<Event> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/event/{id}", Event.class, id);
            return Optional.of(responseEntity.getBody());
        }
        catch (HttpClientErrorException e) {
            return Optional.empty();
        }
    }

}
