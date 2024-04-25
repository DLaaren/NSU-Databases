package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // query json column
    @Query(value = "SELECT w.name ->> 'secondName' FROM Worker w WHERE w.id = :id", nativeQuery = true)
    String getSecondNameByWorkerId(@Param("id") Long id);

    @Query(value = "SELECT w.name ->> 'firstName' FROM Worker w WHERE w.id = :id", nativeQuery = true)
    String getFirstNameByWorkerId(@Param("id") Long id);

    // inner join
    // get all trainer who are responsible for the animal
    @Query("SELECT t FROM Trainer t INNER JOIN t.animals a WHERE a.id = :id")
    List<Worker> getAllTrainersAreResponsibleForAnimalByAnimalId(@Param("id") Long id);
}