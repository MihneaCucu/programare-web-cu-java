
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
        List<String> categories = new ArrayList<>();

        for (Event event : events) {
            if (!categories.contains(event.getCategory())) {
                categories.add(event.getCategory());
            }
        }

        return categories;
    }

    // EXERCISE 3
    public Event addEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
        return event;
    }

    // EXERCISE 4
    public Map<String, Integer> getSummary() {
        return Map.of(
                "totalEvents", events.size(),
                "totalCategories", getCategories().size()
        );
    }
}
