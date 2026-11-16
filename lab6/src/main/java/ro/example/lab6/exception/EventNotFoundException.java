package ro.example.lab6.exception;

// EXERCISE 1 - Custom Exception
public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        // TODO: Create a meaningful error message
        // that includes the ID of the missing event.

        super("Event not found");
    }
}