package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        if (animals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(animals);
    }

    @GetMapping("{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") Long animalId) {
        Optional<Animal> animal = animalService.getAnimalById(animalId);
        if (!animal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(animal.get());
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        Animal registeredAnimal = animalService.addAnimal(animal);
        return new ResponseEntity<>(registeredAnimal, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") Long animalId,
                                               @RequestBody Animal animal) {
        Optional<Animal> _animal = animalService.updateAnimalById(animalId, animal);
        if (!_animal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(_animal.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("id") Long animalId) {
        animalService.deleteAnimalById(animalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
