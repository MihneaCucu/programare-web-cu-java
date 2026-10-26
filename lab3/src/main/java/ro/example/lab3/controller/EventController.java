package ro.example.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        // TODO 1: Obtineti lista evenimentelor din EventService.
        // TODO 2: Adaugati lista in Model cu numele "events".

        return "events";
    }


    @GetMapping("/events/new")
    public String showAddEventForm(Model model) {

        model.addAttribute("event", new Event());

        return "event-form";
    }

    // TODO 3: Adaugati @PostMapping pentru ruta /events
    public String addEvent(
            // TODO 4: Folositi @ModelAttribute
            Event event) {

        // TODO 5: Apelati eventService.addEvent(event)

        return "redirect:/events";
    }

}
