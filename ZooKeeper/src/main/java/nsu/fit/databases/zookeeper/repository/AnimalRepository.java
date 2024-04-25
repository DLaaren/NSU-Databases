package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // returns pairs of animal and last time injection of the vaccine
    @Query("SELECT an, max(dat) FROM " +
                "(SELECT a AS an, rec.vaccine AS vacc, rec.date AS dat FROM VaccinationHistoryRecord rec " +
                "JOIN rec.vetCard v " +
                "RIGHT JOIN v.animal a " +
                "ORDER BY rec.date) " +
            "GROUP BY an, vacc " +
            "HAVING vacc = :vaccine")
    Map<Animal, Date> findAllByLastVaccine(@Param("vaccine") String vaccine);

    @Modifying
    @Query(value = "CALL appoint_trainer_for_animal(:#{#trainer.id}, :#{#animal.id})", nativeQuery = true)
    void appointTrainerForAnimal(@Param("trainer") Trainer trainer, @Param("animal") Animal animal);

    @Query("SELECT a.trainers FROM Animal a WHERE a.id = :id")
    List<Trainer> getTrainersByAnimalId(@Param("id") Long id);
}
