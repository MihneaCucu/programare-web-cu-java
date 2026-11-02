
package ro.example.lab4.controller;

import org.springframework.web.bind.annotation.*;
import ro.example.lab4.model.Event;
import ro.example.lab4.service.EventService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }


    // EXERCISE 1 - Get all events
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // EXERCISE 2 - Get distinct categories
    @GetMapping("/categories")
    public List<String> getCategories() {
        return eventService.getCategories();
    }

    // EXERCISE 3 - Create an event
    @PostMapping(
            value = "/events",
            consumes = "application/x-www-form-urlencoded"
    )
    public Event createEvent(@ModelAttribute Event event) {
        return eventService.addEvent(event);
    }

    // EXERCISE 4 - Events summary
    @GetMapping("/events/summary")
    public Map<String, Integer> getSummary() {
        return eventService.getSummary();
    }
}
