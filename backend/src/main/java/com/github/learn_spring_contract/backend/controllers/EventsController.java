package com.github.learn_spring_contract.backend.controllers;

import com.github.learn_spring_contract.backend.json.EventDTO;
import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@RestController
public class EventsController {

    @RequestMapping(path = "/event", method= RequestMethod.GET)
    public Collection<EventDTO> getEvents() {
        return ImmutableList.of(
                EventDTO.builder().id(UUID.randomUUID()).start(Instant.now()).description("State of the Nation").speaker("Johan Malmliden").location("Adelsö").build(),
                EventDTO.builder().id(UUID.randomUUID()).start(Instant.now()).description("Att bygga en speldator").speaker("Fredrik Löfgren").location("Färingsö").build(),
                EventDTO.builder().id(UUID.randomUUID()).start(Instant.now()).description("Konsumentdrivna kotraktstester").speaker("Martin Carlsson").location("Lovön").build(),
                EventDTO.builder().id(UUID.randomUUID()).start(Instant.now()).description("Morötter").speaker("Snurre Sprätt").location("Trädgårdslandet").build()
        );
    }
}
