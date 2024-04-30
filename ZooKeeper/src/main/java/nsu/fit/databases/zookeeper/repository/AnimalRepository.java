package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    List<Object[]> findAllByLastVaccine(@Param("vaccine") String vaccine);

    @Modifying
    @Query(value = "CALL appoint_trainer_for_animal(:#{#trainer.id}, :#{#animal.id})", nativeQuery = true)
    void appointTrainerForAnimal(@Param("trainer") Trainer trainer, @Param("animal") Animal animal);

    @Query("SELECT a.trainers FROM Animal a WHERE a.id = :id")
    List<Trainer> getTrainersByAnimalId(@Param("id") Long id);

//    WITH предоставляет способ записывать дополнительные операторы для применения в больших запросах.
//    Эти операторы, которые также называют общими табличными выражениями (Common Table Expressions, CTE),
//    можно представить как определения временных таблиц, существующих только для одного запроса.
    // find ancestors
    @Query(value = "WITH RECURSIVE ancestor AS ( " +
                       "SELECT pc.mother_id, pc.father_id FROM animal " +
                       "JOIN parents_children AS pc ON animal.id = pc.child_id " +
                       "WHERE pc.child_id = :id " +

                       "UNION ALL " +

                       "SELECT pc.mother_id, pc.father_id FROM ancestor, parents_children AS pc " +
                       "WHERE pc.child_id IN (ancestor.mother_id, ancestor.father_id)) " +

                   "SELECT DISTINCT id FROM ( " +
                        "SELECT mother_id AS id FROM ancestor " +

                        "UNION " +

                        "SELECT father_id AS id FROM ancestor) tmp ",
            nativeQuery = true)
    List<Long> findAnimalIdsAncestorsById(@Param("id") Long id);
}
