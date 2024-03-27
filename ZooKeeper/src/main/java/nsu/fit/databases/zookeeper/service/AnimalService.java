package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> getAllAnimals();

    Optional<Animal> getAnimalById(Long animalId);

    Animal addAnimal(Animal animal);

    Optional<Animal> updateAnimalById(Long animalId, Animal animal);

    void deleteAnimalById(Long animalId);
}
