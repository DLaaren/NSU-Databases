package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.VaccinationHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface VaccinationHistoryRecordRepository extends JpaRepository<VaccinationHistoryRecord, Long> {
    @Query("SELECT rec FROM VaccinationHistoryRecord rec WHERE rec.vetCard.id = :vetCardId ORDER BY rec.date")
    List<VaccinationHistoryRecord> findAllByVetCardId(@Param("vetCardId") Long vetCardId);
}
