
package ro.example.lab5.service;

import org.springframework.stereotype.Service;
import ro.example.lab5.model.Event;

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


    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();

        for (Event event : events) {
            if (!categories.contains(event.getCategory())) {
                categories.add(event.getCategory());
            }
        }

        return categories;
    }

    public Event addEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
        return event;
    }

    public Map<String, Integer> getSummary() {
        return Map.of(
                "totalEvents", events.size(),
                "totalCategories", getCategories().size()
        );
    }


    // EXERCISE 1 - Find event by ID
    public Event getEventById(Long id) {
        // TODO: Search for the event with the given ID.
        // TODO: Return the event if found, otherwise return null.
        return null;
    }


    // EXERCISE 2 - Filter events by category
    public List<Event> getEventsByCategory(String category) {
        // TODO: Filter the events list by category.
        // TODO: Return only the events whose category matches.
        return List.of();
    }

    // EXERCISE 4 - Update an event
    public Event updateEvent(Long id, Event updatedEvent) {
        // TODO: Find the event with the given ID.
        // TODO: Update its name and category.
        // TODO: Return the updated event.
        // TODO: Return null if the event doesn't exist.

        return null;
    }

    // EXERCISE 4 - Delete an event
    public boolean deleteEvent(Long id) {
        // TODO: Find the event with the given ID.
        // TODO: Remove it from the list.
        // TODO: Return true if deleted, false otherwise.

        return false;
    }

}
