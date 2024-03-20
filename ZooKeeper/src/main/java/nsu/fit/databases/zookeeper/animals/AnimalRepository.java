package nsu.fit.databases.zookeeper.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
//        Optional<Animal> findByName(String name);
//        Optional<Animal> findById(Long id);
}
