package com.github.learn_spring_contract.frontend.clients;

import com.github.learn_spring_contract.frontend.dtos.EventDTO;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class EventDTOsClient {
    public List<EventDTO> getEventDTOs() {
        return ImmutableList.of(
                EventDTO.builder().start(Instant.now()).description("State of the Nation").speaker("Johan Malmliden").location("").build(),
                EventDTO.builder().start(Instant.now()).description("Att bygga en speldator").speaker("Fredrik Löfgren").location("").build(),
                EventDTO.builder().start(Instant.now()).description("Konsumentdrivna kotraktstester").speaker("Martin Carlsson").location("").build(),
                EventDTO.builder().start(Instant.now()).description("Morötter").speaker("Snurre Sprätt").location("").build()
        );
    }
}
