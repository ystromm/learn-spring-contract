package com.github.ystromm.learn_spring_contract.backend.repository;

import com.github.ystromm.learn_spring_contract.backend.json.Event;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class EventRepository {

    private final Event event1 = Event.builder().
            id(1).
            description("State of the Nation").
            speaker("Johan Malmliden").
            location("Adelsö").
            build();
    private final Event event2 = Event.builder().
            id(2).
            description("Konsumentdrivna kontraktstester").
            speaker("Martin Carlsson").
            location("Färingsö").
            build();
    private final Event event3 = Event.builder().
            id(3).
            description("Att bygga en speldator").
            speaker("Fredrik Löfgren").
            location("Lovö").
            build();
    private final Map<Integer, Event> events = ImmutableMap.of(
            event1.getId(), event1,
            event2.getId(), event2,
            event3.getId(), event3);

    public Collection<Event> getAll() {
        return events.values();
    }

    public Optional<Event> get(int id) {
        return Optional.ofNullable(events.get(id));
    }
}
