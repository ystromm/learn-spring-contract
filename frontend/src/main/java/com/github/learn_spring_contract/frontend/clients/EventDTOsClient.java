package com.github.learn_spring_contract.frontend.clients;

import com.github.learn_spring_contract.frontend.dtos.EventDTO;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class EventDTOsClient {

    private final RestTemplate restTemplate;

    @Autowired
    EventDTOsClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<EventDTO> getEventDTOs() {
        final ResponseEntity<EventDTO[]> responseEntity = restTemplate.getForEntity("localhost:8081/event", EventDTO[].class);
        return ImmutableList.copyOf(responseEntity.getBody());
    }

    public EventDTO getEventDTO(UUID id) {
        final ResponseEntity<EventDTO> responseEntity = restTemplate.getForEntity("/event/{id}", EventDTO.class, id);
        return responseEntity.getBody();
    }

}
