
package ro.example.lab7.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.example.lab7.model.Event;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // EXERCISE 2 - JdbcTemplate

    // TODO 1: Retrieve all events from the database.
    // Use jdbcTemplate.query() and a RowMapper.
    public List<Event> findAll() {
        throw new UnsupportedOperationException("TODO: implement findAll");
    }

    // TODO 2: Find an event by ID using a parameterized query.
    // Return Optional.empty() when the event does not exist.
    public Optional<Event> findById(long id) {
        throw new UnsupportedOperationException("TODO: implement findById");
    }


    // EXERCISE 3 - Database Operations

    // TODO 3: Insert a new event into the database.
    // Use INSERT ... RETURNING id to retrieve the generated ID.
    public Long save(String name, String category) {
        throw new UnsupportedOperationException("TODO: implement save");
    }

    // TODO 4: Update an existing event by ID.
    // Return the number of affected rows.
    public int updateById(long id, String name, String category) {
        throw new UnsupportedOperationException("TODO: implement updateById");
    }

    // TODO 5: Delete an event by ID.
    // Return the number of affected rows.
    public int deleteById(long id) {
        throw new UnsupportedOperationException("TODO: implement deleteById");
    }
}
