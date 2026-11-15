package ro.example.lab6.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// EXERCISE 2 - Global Exception Handling

// TODO: Add @RestControllerAdvice to handle exceptions globally.
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            EventNotFoundException ex,
            HttpServletRequest request) {

        Map<String, Object> errorResponse = Map.of(
                "status", 404,
                "error", "Not Found",
                "message", ex.getMessage(),
                "path", request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    // EXERCISE 4 - Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> fieldErrors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        }

        Map<String, Object> errorResponse = Map.of(
                "status", 400,
                "error", "Bad Request",
                "message", "Validation failed",
                "fieldErrors", fieldErrors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
