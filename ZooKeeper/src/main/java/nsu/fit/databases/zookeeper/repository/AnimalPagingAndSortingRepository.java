package nsu.fit.databases.zookeeper.repository;

import nsu.fit.databases.zookeeper.entity.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimalPagingAndSortingRepository extends PagingAndSortingRepository<Animal, Long> {

}
