package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
