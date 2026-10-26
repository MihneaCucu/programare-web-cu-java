package ro.example.lab3.service;

import org.springframework.stereotype.Service;
import ro.example.lab3.model.Event;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private long nextId = 3L;

    public EventService() {
        events.add(new Event(1L, "Java Workshop", "Technology"));
        events.add(new Event(2L, "Spring Boot Lab", "Education"));
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public void addEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
    }
}
