
package ro.example.lab6.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.example.lab6.model.Event;
import ro.example.lab6.service.EventService;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/events/summary")
    public Map<String, Integer> getSummary() {
        return eventService.getSummary();
    }




    // EXERCISE 2 - Use global exception handling
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(
            @PathVariable("id") Long id) {

        Event event = eventService.getEventById(id);

        return ResponseEntity.ok(event);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents(
            @RequestParam(value = "category", required = false)
            String category) {

        if (category == null || category.isBlank()) {
            return eventService.getAllEvents();
        }

        return eventService.getEventsByCategory(category);
    }


    @GetMapping("/categories")
    public List<String> getCategories() {
        return eventService.getCategories();
    }



    // EXERCISE 3 - Validate event creation
    @PostMapping(
            value = "/events",
            consumes = "application/json"
    )
    public ResponseEntity<Event> createEvent(
            @Valid @RequestBody Event event) {

        Event createdEvent = eventService.addEvent(event);

        URI location = URI.create(
                "/api/events/" + createdEvent.getId()
        );

        return ResponseEntity
                .created(location)
                .body(createdEvent);
    }



    // EXERCISE 3 - Validate event updates
    @PutMapping(
            value = "/events/{id}",
            consumes = "application/json"
    )
    public ResponseEntity<Event> updateEvent(
            @PathVariable("id") Long id,
            @Valid @RequestBody Event updatedEvent) {

        Event event = eventService.updateEvent(id, updatedEvent);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(event);
    }



    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(
            @PathVariable("id") Long id) {

        boolean deleted = eventService.deleteEvent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }



    @GetMapping("/client-info")
    public Map<String, String> getClientInfo(
            @RequestHeader(
                    value = "X-Client",
                    defaultValue = "unknown"
            ) String client) {

        return Map.of("client", client);
    }
}
