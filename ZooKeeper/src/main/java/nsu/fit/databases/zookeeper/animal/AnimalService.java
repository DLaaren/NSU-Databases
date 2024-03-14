package nsu.fit.databases.zookeeper.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal addNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public ResponseEntity<Animal> updateAnimal(Animal animal) {
        return (!animalRepository.existsById(animal.getId()))
                ? new ResponseEntity<>(animalRepository.save(animal),
                HttpStatus.CREATED)
                : new ResponseEntity<>(animalRepository.save(animal), HttpStatus.OK);
    }

    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }
}
