package nsu.fit.databases.zookeeper.service;


import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.AnimalPagingAndSortingRepository;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnimalService {

    private final AnimalPagingAndSortingRepository animalPagingAndSortingRepository;
    private final AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Page<Animal> getAllAnimalsPageable(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return animalPagingAndSortingRepository.findAll(page);
    }

    public Page<Animal> getAllAnimalsPageableSortedDesc(int pageNumber, int pageSize, String sortedBy) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(sortedBy).descending());
        return animalPagingAndSortingRepository.findAll(page);
    }

    public Page<Animal> getAllAnimalsPageableSortedAsc(int pageNumber, int pageSize, String sortedBy) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(sortedBy).ascending());
        return animalPagingAndSortingRepository.findAll(page);
    }

    public Animal getAnimalByIdOrThrow(Long id) {
        return animalRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "Animal with id " + id + " does not exist")
        );
    }

    public void nonExistOrThrow(Animal animal) {
        animalRepository.findById(animal.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "Animal with id " + usr.getId() + " already exists");
        });
    }

    public Animal getAnimalById(Long id) {
        return getAnimalByIdOrThrow(id);
    }

    public Animal addAnimal(Animal animal) {
        nonExistOrThrow(animal);
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        nonExistOrThrow(animal);
        return animalRepository.save(animal);
    }

    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }
}
