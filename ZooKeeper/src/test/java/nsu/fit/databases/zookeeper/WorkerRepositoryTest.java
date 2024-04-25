package nsu.fit.databases.zookeeper;

import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.Worker;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.repository.WorkerRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkerRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private WorkerRepository workerRepository;

    @DisplayName("testWorkerCRUD")
    @Test
    public void testWorkerCRUD() {
        assertNotNull(workerRepository);

        Name name = new Name();
        name.setFirstName("Misha");
        // we don't need to set id, 'cause database will use its own strategy
        Worker worker = new Worker(null, name, 12.3, JobTitle.CLEANER);

        // save worker
        worker = workerRepository.saveAndFlush(worker);
        
        // find worker by id
        Worker result = workerRepository.getReferenceById(worker.getId());
        assertNotNull(result);
        assertEquals("Misha", result.getName().getFirstName());
        assertEquals(12.3, result.getSalary());
        assertEquals(JobTitle.CLEANER, result.getJobTitle());

        // update worker
        name.setFirstName("Aboba");
        worker.setName(name);
        worker.setSalary(0);
        worker.setJobTitle(null);

        // find worker by id
        Worker result2 = workerRepository.getReferenceById(worker.getId());
        assertNotNull(result2);
        assertEquals("Aboba", result2.getName().getFirstName());
        assertEquals(0, result2.getSalary());
        assertNull(result2.getJobTitle());

        // delete worker
        workerRepository.delete(worker);

        // check if is empty
        assertTrue(workerRepository.findById(worker.getId()).isEmpty());
    }

    @Test
    @DisplayName("testWorkerQueryJsonColumn")
    public void testWorkerQueryJsonColumn() {
        assertNotNull(workerRepository);
    }


    // show a list of animals for each trainer
    @Test
    @DisplayName("testTrainerAnimalJoin")
    public void testTrainerAnimalJoin() {
        assertNotNull(workerRepository);
    }
}
