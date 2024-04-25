package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Map;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // returns pairs of animal and last time injection of the vaccine or null
    // think about where
    @Query("SELECT an, max(dat) FROM " +
                "(SELECT a AS an, rec.vaccine AS vacc, rec.date AS dat FROM VaccinationHistoryRecord rec " +
                "JOIN rec.vetCard v " +
                "RIGHT JOIN v.animal a " +
                "WHERE rec.vaccine = :vaccine or rec.vaccine IS NULL " +
                "ORDER BY rec.date) " +
            "GROUP BY an, vacc ")
    Map<Animal, Date> findAllByLastVaccine(@Param("vaccine") String vaccine);
}
