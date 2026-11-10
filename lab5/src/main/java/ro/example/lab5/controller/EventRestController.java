
package ro.example.lab5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.example.lab5.model.Event;
import ro.example.lab5.service.EventService;

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


    // EXERCISE 1 - Get event by ID
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(
            // TODO: Add the annotation to extract the ID from the URL.
            Long id) {

        // TODO: Find the event using EventService.
        // TODO: Return 200 OK if found.
        // TODO: Return 404 Not Found otherwise.

        return ResponseEntity.notFound().build();
    }

    // EXERCISE 2 - Filter events by category
    @GetMapping("/events")
    public List<Event> getAllEvents(
            // TODO: Add the annotation for an optional query parameter.
            String category) {

        if (category == null || category.isBlank()) {
            return eventService.getAllEvents();
        }

        // TODO: Return events filtered by category.
        return List.of();
    }


    @GetMapping("/categories")
    public List<String> getCategories() {
        return eventService.getCategories();
    }

    // EXERCISE 3 - Create event using JSON
    @PostMapping(
            value = "/events",
            consumes = "application/json"
    )
    public ResponseEntity<Event> createEvent(
            // TODO: Add the annotation to read JSON
            // from the HTTP request body.
            Event event) {

        // TODO: Add the event using EventService.
        // TODO: Return 201 Created with the event.
        // TODO: Set the Location header to /api/events/{id}.

        return ResponseEntity.status(501).build();
    }

    // EXERCISE 4 - Update an event
    @PutMapping(
            value = "/events/{id}",
            consumes = "application/json"
    )
    public ResponseEntity<Event> updateEvent(
            // TODO: Add the annotation to extract the ID from the URL.
            Long id,

            // TODO: Add the annotation to read the JSON request body.
            Event updatedEvent) {

        // TODO: Call EventService to update the event.
        // TODO: Return 200 OK with the updated event.
        // TODO: Return 404 Not Found if the event doesn't exist.

        return ResponseEntity.status(501).build();
    }


    // EXERCISE 4 - Delete an event
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(
            // TODO: Add the annotation to extract the ID from the URL.
            Long id) {

        // TODO: Call EventService to delete the event.
        // TODO: Return 204 No Content if deleted.
        // TODO: Return 404 Not Found otherwise.

        return ResponseEntity.status(501).build();
    }


    // EXERCISE 5 - Read HTTP Headers
    @GetMapping("/client-info")
    public Map<String, String> getClientInfo(
            // TODO: Add @RequestHeader to read "X-Client".
            // TODO: Use "unknown" as the default value.
            String client) {

        // TODO: Return a Map containing:
        // "client" -> the received header value.

        return Map.of();
    }
}
