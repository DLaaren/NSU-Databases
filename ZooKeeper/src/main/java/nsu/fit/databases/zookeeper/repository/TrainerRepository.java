package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    @Query("SELECT t.animals FROM Trainer t WHERE t.id = :id")
    List<Animal> getAnimalsByTrainerId(@Param("id") Long id);
}
