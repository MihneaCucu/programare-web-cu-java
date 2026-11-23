
package ro.example.lab7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile("jdbc-demo")
public class JdbcDemoRunner implements CommandLineRunner {

    private final DataSource dataSource;

    public JdbcDemoRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {

        long eventId = 2L;

        // EXERCISE 1 - JDBC Fundamentals

        // TODO 1: Obtain a Connection from the DataSource.
        // Use try-with-resources.

        // TODO 2: Create a PreparedStatement that selects
        // an event by its ID.

        // TODO 3: Bind eventId to the SQL parameter.

        // TODO 4: Execute the query and obtain a ResultSet.

        // TODO 5: Read and display the event's
        // id, name and category.

        // TODO 6: Handle the case when no event is found.
    }
}
