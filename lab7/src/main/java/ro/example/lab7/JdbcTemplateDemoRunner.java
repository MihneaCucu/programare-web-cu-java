package ro.example.lab7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.example.lab7.model.Event;
import ro.example.lab7.repository.EventRepository;

import java.util.List;

@Component
@Profile("template-demo")
public class JdbcTemplateDemoRunner implements CommandLineRunner {

    private final EventRepository eventRepository;

    public JdbcTemplateDemoRunner(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) {

        List<Event> events = eventRepository.findAll();

        System.out.println("JdbcTemplate - Events found: " + events.size());

        eventRepository.findById(2L)
                .ifPresentOrElse(
                        event -> System.out.println(
                                "Found event: " + event.getName()
                        ),
                        () -> System.out.println("Event not found!")
                );
    }
}
