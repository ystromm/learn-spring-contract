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

    public static final String BASE_URL = "http://localhost:8081/event";
    private final RestTemplate restTemplate;

    @Autowired
    EventClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Collection<Event> getAll() {
        final ResponseEntity<Event[]> responseEntity = restTemplate.getForEntity(BASE_URL, Event[].class);
        return Arrays.asList(responseEntity.getBody());
//        final Event event1 = Event.builder().description("Konsumentdrivna kontraktstester").id(1).speaker("Martin Carlsson").location("location").build();
//        final Event event2 = Event.builder().description("Att bygga en speldator").id(2).speaker("Fredrik Löfgren").location("location").build();
//        final Event event3 = Event.builder().description("State of the Nation").id(3).speaker("Johan Malmliden").location("location").build();
//        return Arrays.asList(event1, event2, event3);
    }

    public Optional<Event> get(int id) {
        try {
            final ResponseEntity<Event> responseEntity = restTemplate.getForEntity(BASE_URL + "/{id}", Event.class, id);
            return Optional.of(responseEntity.getBody());
        }
        catch (HttpClientErrorException e) {
            return Optional.empty();
        }
    }

}
