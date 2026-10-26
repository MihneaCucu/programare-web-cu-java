package ro.example.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.example.lab3.model.Event;
import ro.example.lab3.service.EventService;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {

        model.addAttribute("events", eventService.getAllEvents());

        return "events";
    }


    @GetMapping("/events/new")
    public String showAddEventForm(Model model) {

        model.addAttribute("event", new Event());

        return "event-form";
    }

    @PostMapping("/events")
    public String addEvent(@ModelAttribute Event event) {

        eventService.addEvent(event);

        return "redirect:/events";
    }

}
