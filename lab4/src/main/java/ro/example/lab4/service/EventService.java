
package ro.example.lab4.service;

import org.springframework.stereotype.Service;
import ro.example.lab4.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 4L;

    public EventService() {
        events.add(new Event(1L, "Java Workshop", "Technology"));
        events.add(new Event(2L, "Spring Boot Lab", "Education"));
        events.add(new Event(3L, "REST Workshop", "Technology"));
    }

    public List<Event> getAllEvents() {
        return events;
    }

    // EXERCISE 2
    public List<String> getCategories() {
        // TODO: Return all distinct event categories.
        return new ArrayList<>();
    }

    // EXERCISE 3
    public Event addEvent(Event event) {
        // TODO: Assign a unique ID to the new event.
        // TODO: Add the event to the list.
        // TODO: Return the created event.
        return null;
    }

    // EXERCISE 4
    public Map<String, Integer> getSummary() {
        // TODO: Return a map containing:
        // "totalEvents" - number of events
        // "totalCategories" - number of distinct categories
        return Map.of();
    }
}
