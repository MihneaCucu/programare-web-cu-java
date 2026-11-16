package ro.example.lab6.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

// EXERCISE 2 - Global Exception Handling

// TODO: Add @RestControllerAdvice to handle exceptions globally.
public class GlobalExceptionHandler {

    // TODO: Add @ExceptionHandler for EventNotFoundException.
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            EventNotFoundException ex,
            HttpServletRequest request) {

        // TODO: Return 404 Not Found.
        // TODO: Include the following fields in a JSON response:
        // - status
        // - error
        // - message
        // - path

        return ResponseEntity.status(501).build();
    }

    // EXERCISE 4 - Handle validation errors

    // TODO: Add @ExceptionHandler for
    // MethodArgumentNotValidException.
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        // TODO: Extract validation errors for each field.
        // Hint: Use ex.getBindingResult().getFieldErrors()

        // TODO: Return 400 Bad Request with:
        // - status: 400
        // - error: "Bad Request"
        // - message: "Validation failed"
        // - fieldErrors: map of field names and error messages

        return ResponseEntity.status(501).build();
    }
}
