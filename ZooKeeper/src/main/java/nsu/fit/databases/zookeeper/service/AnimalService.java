package nsu.fit.databases.zookeeper.service;


import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    public Animal addAnimal(Animal animal) {
        animalRepository.save(animal);
        return animal;
    }

    public Optional<Animal> updateAnimalById(Long animalId, Animal animal) {
        if (!animalRepository.findById(animalId).isPresent()) {
            return Optional.empty();
        }
        animalRepository.save(animal);
        return Optional.of(animal);
    }

    public void deleteAnimalById(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
