package nsu.fit.databases.zookeeper;

import nsu.fit.databases.zookeeper.entity.*;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import nsu.fit.databases.zookeeper.repository.WorkerRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkerRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private SpeciesRepository speciesRepository;

    @DisplayName("testWorkerCRUD")
    @Test
    public void testWorkerCRUD() {
        Name name = new Name();
        name.setFirstName("Misha");
        // we don't need to set id, 'cause database will use its own strategy
        Worker worker = new Worker(null, name, 24, 12.3, JobTitle.CLEANER);

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
        worker.setSalary(0.0);
        worker.setJobTitle(null);

        // find worker by id
        Worker result2 = workerRepository.getReferenceById(worker.getId());
        assertNotNull(result2);
        assertEquals(result2.getName().getFirstName(), "Aboba");
        assertEquals(result2.getSalary(), 0.0);
        assertNull(result2.getJobTitle());

        // delete worker
        workerRepository.delete(worker);

        // check if is empty
        assertTrue(workerRepository.findById(worker.getId()).isEmpty());
    }

    @Test
    @DisplayName("testWorkerQueryJsonColumn")
    public void testWorkerQueryJsonColumn() {
        Name name = new Name();
        name.setFirstName("Misha");
        name.setMiddleName("Alexander");
        name.setSecondName("Popov");
        name.setPatronymicName("Victorovich");

        Worker worker = new Worker(null, name, null, null, null);
        worker = workerRepository.saveAndFlush(worker);

        assertEquals(workerRepository.getFirstNameByWorkerId(worker.getId()), "Misha");
        assertEquals(workerRepository.getMiddleNameByWorkerId(worker.getId()), "Alexander");
        assertEquals(workerRepository.getSecondNameByWorkerId(worker.getId()), "Popov");
        assertEquals(workerRepository.getPatronymicNameByWorkerId(worker.getId()), "Victorovich");
    }


    // show a list of animals for each trainer
    @Test
    @DisplayName("testTrainerAnimalJoin")
    public void testTrainerAnimalJoin() {
        Animal animal = new Animal();

        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();
        Trainer trainer3 = new Trainer();
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        name1.setFirstName("Trainer1");
        name2.setFirstName("Trainer2");
        name3.setFirstName("Trainer3");
        trainer1.setName(name1);
        trainer1.setAnimals(List.of(animal));
        trainer2.setName(name2);
        trainer2.setAnimals(List.of(animal));
        trainer3.setName(name3);
        trainer3.setAnimals(List.of(animal));
        List<Trainer> trainers = List.of(trainer1,trainer2,trainer3);

        Species species = new Species();
        species.setSpeciesName("Chicken");
        species = speciesRepository.saveAndFlush(species);

        animal.setSpecies(species);
        animal.setName("Bob");
        animal.setTrainers(trainers);

        trainers = workerRepository.saveAllAndFlush(trainers);

        animal = animalRepository.saveAndFlush(animal);

        List<Trainer> returnedTrainers = workerRepository.getAllTrainersAreResponsibleForTheAnimal(animal);

        assertArrayEquals(trainers.toArray(), returnedTrainers.toArray());
    }
}
