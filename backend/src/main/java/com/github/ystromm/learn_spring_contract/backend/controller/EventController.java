package com.github.ystromm.learn_spring_contract.backend.controller;

import com.github.ystromm.learn_spring_contract.backend.json.Event;
import com.github.ystromm.learn_spring_contract.backend.repository.EventRepository;
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
    EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Event> getEvents() {
        return eventRepository.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvents(@PathVariable("id") int id) {
        return eventRepository.get(id).orElseThrow(NotFoundException::new);
    }

}
