package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Trainer;
import nsu.fit.databases.zookeeper.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // query json column
    @Query(value = "SELECT w.name->>'secondName' FROM worker w WHERE w.id = :id", nativeQuery = true)
    String getSecondNameByWorkerId(@Param("id") Long id);

    @Query(value = "SELECT w.name->>'firstName' FROM worker w WHERE w.id = :id", nativeQuery = true)
    String getFirstNameByWorkerId(@Param("id") Long id);

    @Query(value = "SELECT w.name->>'middleName' FROM worker w WHERE w.id = :id", nativeQuery = true)
    String getMiddleNameByWorkerId(@Param("id") Long id);

    @Query(value = "SELECT w.name->>'patronymicName' FROM worker w WHERE w.id = :id", nativeQuery = true)
    String getPatronymicNameByWorkerId(@Param("id") Long id);

    // inner join
    // get all trainer who are responsible for the animal
    @Query("SELECT t FROM Trainer t INNER JOIN t.animals a WHERE a = :animal")
    List<Trainer> getAllTrainersAreResponsibleForTheAnimal(@Param("animal") Animal animal);
}