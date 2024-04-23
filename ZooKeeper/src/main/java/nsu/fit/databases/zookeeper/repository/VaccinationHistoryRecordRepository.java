package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.VaccinationHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationHistoryRecordRepository extends JpaRepository<VaccinationHistoryRecord, Long> {
    List<VaccinationHistoryRecord> findAllByVetCardId(Long vetCardId);
}
