package nsu.fit.databases.zookeeper;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.entity.Trainer;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import nsu.fit.databases.zookeeper.repository.TrainerRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalRepositoryTest extends BaseRepositoryTest {
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    SpeciesRepository speciesRepository;

    @DisplayName("testProcedure")
    @Test
    public void testProcedure() {
        Animal animal = new Animal();

        Species species = new Species();
        species.setSpeciesName("Duck");
        species = speciesRepository.saveAndFlush(species);

        animal.setSpecies(species);
        animal.setName("Mac");
        animal = animalRepository.saveAndFlush(animal);

        Trainer trainer = new Trainer();
        Name name = new Name();
        name.setSecondName("CoolMan");
        trainer.setName(name);
        trainer.setAge(25);

        trainer =trainerRepository.saveAndFlush(trainer);

        assertNotNull(animal);
        assertNotNull(trainer);

        animalRepository.appointTrainerForAnimal(trainer, animal);
        animalRepository.flush();

        animal = animalRepository.getReferenceById(animal.getId());
        trainer = trainerRepository.getReferenceById(trainer.getId());

        List<Trainer> returnedTrainers = animalRepository.getTrainersByAnimalId(animal.getId());
        List<Animal> returnedAnimals = trainerRepository.getAnimalsByTrainerId(trainer.getId());

        assertNotNull(returnedTrainers);
        assertNotNull(returnedAnimals);

        assertEquals(returnedAnimals.get(0), animal);
        assertEquals(returnedTrainers.get(0), trainer);
    }
}
