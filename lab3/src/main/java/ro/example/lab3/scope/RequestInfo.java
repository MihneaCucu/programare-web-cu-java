package ro.example.lab3.scope;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// TODO: Adaugati @RequestScope pentru a crea
// o instanta noua la fiecare cerere HTTP.
public class RequestInfo {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
