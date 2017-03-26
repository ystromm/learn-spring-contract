package com.github.learn_spring_contract.frontend.controllers;

import com.github.learn_spring_contract.frontend.clients.EventDTOsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScheduleController {


    private final EventDTOsClient eventDTOsClient;

    @Autowired
    public ScheduleController(EventDTOsClient eventDTOsClient) {
        this.eventDTOsClient = eventDTOsClient;
    }

    @RequestMapping("/")
    public String shedule(Model model) {
        model.addAttribute("events", eventDTOsClient.getEventDTOs());
        return "schedule";
    }

}
