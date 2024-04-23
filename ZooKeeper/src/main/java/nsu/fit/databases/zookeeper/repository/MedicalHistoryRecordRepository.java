package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.MedicalHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalHistoryRecordRepository extends JpaRepository<MedicalHistoryRecord, Long> {
    List<MedicalHistoryRecord> findAllByVetCardId(Long vetCardId);
}
