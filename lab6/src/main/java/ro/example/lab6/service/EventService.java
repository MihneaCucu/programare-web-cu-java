
package ro.example.lab6.service;

import org.springframework.stereotype.Service;
import ro.example.lab6.exception.EventNotFoundException;
import ro.example.lab6.model.Event;

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



    // EXERCISE 1 - Throw custom exception
    public Event getEventById(Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }

        throw new EventNotFoundException(id);
    }



    public List<Event> getEventsByCategory(String category) {
        List<Event> filteredEvents = new ArrayList<>();

        for (Event event : events) {
            if (event.getCategory().equalsIgnoreCase(category)) {
                filteredEvents.add(event);
            }
        }

        return filteredEvents;
    }


    public Event updateEvent(Long id, Event updatedEvent) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                event.setName(updatedEvent.getName());
                event.setCategory(updatedEvent.getCategory());

                return event;
            }
        }

        return null;
    }


    public boolean deleteEvent(Long id) {
        return events.removeIf(
                event -> event.getId().equals(id)
        );
    }

}
