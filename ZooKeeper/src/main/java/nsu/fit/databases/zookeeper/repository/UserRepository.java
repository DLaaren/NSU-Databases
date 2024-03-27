package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
