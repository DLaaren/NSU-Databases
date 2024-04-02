package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
