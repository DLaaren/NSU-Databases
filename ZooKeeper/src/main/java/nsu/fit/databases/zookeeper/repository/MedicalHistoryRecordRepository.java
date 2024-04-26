package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.entity.MedicalHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalHistoryRecordRepository extends JpaRepository<MedicalHistoryRecord, Long> {
    @Query("SELECT rec FROM MedicalHistoryRecord rec WHERE rec.vetCard.id = :vetCardId ORDER BY rec.date")
    List<MedicalHistoryRecord> findAllByVetCardId(@Param("vetCardId") Long vetCardId);
}
