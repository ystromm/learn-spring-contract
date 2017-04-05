package com.github.ystromm.learn_spring_contract.frontend.controller;

import com.github.ystromm.learn_spring_contract.frontend.clients.EventClient;
import com.github.ystromm.learn_spring_contract.frontend.json.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class ScheduleController {
    private static Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    private final EventClient eventClient;

    @Autowired
    public ScheduleController(EventClient eventClient) {
        this.eventClient = eventClient;
    }

    @RequestMapping("/")
    public String schedule(Model model) {
        final Collection<Event> events = eventClient.getAll();
        logger.info("events={}", events);
        model.addAttribute("events", events);
        return "schedule";
    }

}
