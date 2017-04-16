package com.github.ystromm.learn_spring_contract.frontend.controller;

import com.github.ystromm.learn_spring_contract.frontend.client.EventClient;
import com.github.ystromm.learn_spring_contract.frontend.json.Event;
import com.github.ystromm.learn_spring_contract.frontend.json.Handelse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TranslationController {

    private final EventClient eventClient;
    private final RestTemplate restTemplate;

    @Autowired
    public TranslationController(EventClient eventClient) {
        this.eventClient = eventClient;
        this.restTemplate = new RestTemplate();
    }

    @RequestMapping(path = "/rest/handelse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Handelse> handelser() {
        return eventClient.getAll().stream().map(TranslationController::toHandelse).collect(Collectors.toList());
    }

    @RequestMapping(path = "/rest/handelse/{id}", method = RequestMethod.GET)
    public Handelse handelse(@PathVariable("id") int id) {
        try {
            return Optional.ofNullable(restTemplate.getForObject("http://localhost:8081/event/" + id, Event.class)).map(event -> toHandelse(event)).orElseThrow(NotFoundException::new);
        }
        catch (RestClientException e) {
            throw new NotFoundException();
        }
        // return eventClient.get(id).map(TranslationController::toHandelse).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(path = "/rest/ping", method = RequestMethod.GET)
    public String ping() {
        return restTemplate.getForObject("http://localhost:8081/ping", String.class);
    }

    private static Handelse toHandelse(Event event) {
        return Handelse.builder()
                .id(event.getId())
                .talare(event.getSpeaker())
                .beskrivning(event.getDescription())
                .plats(event.getLocation())
                .build();
    }
}
