package com.github.ystromm.learn_spring_contract.frontend.controller;

import com.github.ystromm.learn_spring_contract.frontend.clients.EventClient;
import com.github.ystromm.learn_spring_contract.frontend.json.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class EventController {

    private final EventClient eventClient;

    @Autowired
    public EventController(EventClient eventClient) {
        this.eventClient = eventClient;
    }

    @RequestMapping("/event/{id}")
    public String schedule(@PathVariable("id") int id,  Model model) {
        final Optional<Event> optionalEvent = eventClient.get(id);
        if (optionalEvent.isPresent()) {
            model.addAttribute("event", optionalEvent.get());
            return "event";
        }
        else {
            return "redirect:/";
        }
    }

}
