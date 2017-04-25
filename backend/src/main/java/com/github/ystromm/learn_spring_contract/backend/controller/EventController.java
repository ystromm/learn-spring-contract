package com.github.ystromm.learn_spring_contract.backend.controller;

import com.github.ystromm.learn_spring_contract.backend.json.Event;
import com.github.ystromm.learn_spring_contract.backend.repository.EventEntity;
import com.github.ystromm.learn_spring_contract.backend.repository.EventRepository;
import com.google.common.collect.Collections2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Event> getEvents() {
        return Collections2.transform(eventRepository.getAll(), eventEntity->event(eventEntity));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvents(@PathVariable("id") int id) {
        return eventRepository.get(id).map(eventEntity -> event(eventEntity)).orElseThrow(NotFoundException::new);
    }

    Event event(EventEntity eventEntity) {
        return Event.builder().
                id(eventEntity.getId())
                .description(eventEntity.getTitle())
                .location(eventEntity.getLocation())
                .speaker(eventEntity.getSpeaker())
                .build();
    }

}
