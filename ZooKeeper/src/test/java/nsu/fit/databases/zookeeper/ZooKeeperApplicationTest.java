package nsu.fit.databases.zookeeper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ZooKeeperApplicationTest extends BaseRepositoryTest{

    @Test
    public void contextLoads() {
    }
}
