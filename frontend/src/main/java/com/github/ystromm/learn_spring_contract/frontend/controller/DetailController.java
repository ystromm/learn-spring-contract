package com.github.ystromm.learn_spring_contract.frontend.controller;

import com.github.ystromm.learn_spring_contract.frontend.client.EventClient;
import com.github.ystromm.learn_spring_contract.frontend.json.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class DetailController {

    private final EventClient eventClient;

    @Autowired
    public DetailController(EventClient eventClient) {
        this.eventClient = eventClient;
    }

    @RequestMapping("/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        final Optional<Event> optionalEvent = eventClient.get(id);
        if (optionalEvent.isPresent()) {
            model.addAttribute("event", optionalEvent.get());
            return "detail";
        }
        else {
            return "redirect:/";
        }
    }

}
