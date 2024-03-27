package nsu.fit.databases.zookeeper.service.impl;


import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import nsu.fit.databases.zookeeper.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        animalRepository.save(animal);
        return animal;
    }

    @Override
    public Optional<Animal> updateAnimalById(Long animalId, Animal animal) {
        if (!animalRepository.findById(animalId).isPresent()) {
            return Optional.empty();
        }
        animalRepository.save(animal);
        return Optional.of(animal);
    }

    @Override
    public void deleteAnimalById(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
