package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
}
