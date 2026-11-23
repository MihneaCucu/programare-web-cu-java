package ro.example.lab6.exception;

// EXERCISE 1 - Custom Exception
public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        super("Event with ID " + id + " was not found");
    }
}