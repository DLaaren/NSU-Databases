package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.VetCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetCardRepository extends JpaRepository<VetCard, Long> {
    // find vet card and
}
