package ro.example.lab7.service;

import org.springframework.stereotype.Service;
import ro.example.lab7.exception.EventNotFoundException;
import ro.example.lab7.model.Event;
import ro.example.lab7.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();

        for (Event event : eventRepository.findAll()) {
            if (!categories.contains(event.getCategory())) {
                categories.add(event.getCategory());
            }
        }

        return categories;
    }

    public Event addEvent(Event event) {
        Long generatedId = eventRepository.save(
                event.getName(),
                event.getCategory()
        );

        event.setId(generatedId);
        return event;
    }

    public Map<String, Integer> getSummary() {
        return Map.of(
                "totalEvents", getAllEvents().size(),
                "totalCategories", getCategories().size()
        );
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<Event> getEventsByCategory(String category) {
        List<Event> filteredEvents = new ArrayList<>();

        for (Event event : eventRepository.findAll()) {
            if (event.getCategory().equalsIgnoreCase(category)) {
                filteredEvents.add(event);
            }
        }

        return filteredEvents;
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        int rowsUpdated = eventRepository.updateById(
                id,
                updatedEvent.getName(),
                updatedEvent.getCategory()
        );

        if (rowsUpdated == 0) {
            return null;
        }

        return new Event(
                id,
                updatedEvent.getName(),
                updatedEvent.getCategory()
        );
    }

    public boolean deleteEvent(Long id) {
        return eventRepository.deleteById(id) > 0;
    }
}
