package com.github.ystromm.learn_spring_contract.backend.repository;

import com.github.ystromm.learn_spring_contract.backend.json.Event;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class EventRepository {

    private final EventEntity eventEntity1 = EventEntity.builder().
            id(1).
            title("State of the Nation").
            description("").
            speaker("Johan Malmliden").
            location("Adelsö").
            start(LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse("2016-11-06T10:00:00"))).
            length(Duration.ofMinutes(30)).
            build();
    private final EventEntity eventEntity2 = EventEntity.builder().
            id(2).
            title("Konsumentdrivna kontraktstester").
            description("").
            speaker("Martin Carlsson").
            location("Färingsö").
            start(LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse("2016-11-06T11:00:00"))).
            length(Duration.ofMinutes(45)).
            build();
    private final EventEntity eventEntity3 = EventEntity.builder().
            id(3).
            title("Att bygga en speldator").
            description("").
            speaker("Fredrik Löfgren").
            location("Lovö").
            start(LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse("2016-11-06T12:00:00"))).
            length(Duration.ofMinutes(45)).
            build();
    private final Map<Integer, EventEntity> eventEntities = ImmutableMap.of(
            eventEntity1.getId(), eventEntity1,
            eventEntity2.getId(), eventEntity2,
            eventEntity3.getId(), eventEntity3);

    public Collection<EventEntity> getAll() {
        return eventEntities.values();
    }

    public Optional<EventEntity> get(int id) {
        return Optional.ofNullable(eventEntities.get(id));
    }
}
