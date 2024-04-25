package nsu.fit.databases.zookeeper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = ZooKeeperApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZooKeeperApplicationTest {

    // we don't need 'beforeAll' and 'afterAll', the @TestContainers will auto start and stop the container
    // will be shared between tests
    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            "postgres:16"
    );

    @Test
    public void contextLoads() {
    }
}
