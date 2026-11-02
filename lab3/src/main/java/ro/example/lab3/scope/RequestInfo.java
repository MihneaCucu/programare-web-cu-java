package ro.example.lab3.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
public class RequestInfo {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
