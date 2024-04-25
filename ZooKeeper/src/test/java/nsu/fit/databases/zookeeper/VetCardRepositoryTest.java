package nsu.fit.databases.zookeeper;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.entity.Trainer;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import nsu.fit.databases.zookeeper.repository.VetCardRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VetCardRepositoryTest extends BaseRepositoryTest {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    SpeciesRepository speciesRepository;
    @Autowired
    VetCardRepository vetCardRepository;

    @DisplayName("testTrigger")
    @Test
    public void testTrigger() {
        Animal animal = new Animal();

        Species species = new Species();
        species.setSpeciesName("Chicken");
        species = speciesRepository.saveAndFlush(species);

        animal.setSpecies(species);
        animal.setName("Petuh");
        animal = animalRepository.saveAndFlush(animal);

        VetCard vetCard = vetCardRepository.getReferenceById(animal.getId());

        assertNotNull(vetCard);
        assertEquals(vetCard.getId(), animal.getId());
    }
}
