package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    @Query("SELECT a.species, count(a) FROM Animal a INNER JOIN a.species GROUP BY a.species")
    Map<Species, Integer> countTotalAnimalsForEachSpecies();
}
