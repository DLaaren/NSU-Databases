package nsu.fit.databases.zookeeper;

import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SpeciesRepositoryTest extends BaseRepositoryTest {
    @Autowired
    SpeciesRepository speciesRepository;

    @DisplayName("testIndex")
    @Test
    public void testIndex() {
        Species species = new Species();
        species.setSpeciesName("Duck");
        species = speciesRepository.saveAndFlush(species);

        Species returnedSpecies = speciesRepository.findBySpeciesName("Duck");

        assertThat(returnedSpecies).isEqualTo(species);
    }
}
