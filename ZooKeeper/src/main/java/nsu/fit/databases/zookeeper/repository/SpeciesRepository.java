package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    @Query("SELECT a.species, count(a) FROM Animal a INNER JOIN a.species GROUP BY a.species")
    List<Object[]> countTotalAnimalsForEachSpecies();

    @Query(value = "SELECT s FROM Species s WHERE s.speciesName = :name")
    Species findBySpeciesName(@Param("name") String name);
}
