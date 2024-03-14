package nsu.fit.databases.zookeeper.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }

    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping("/")
    public Animal postAnimal(@RequestBody Animal animal) {
        return animalService.addNewAnimal(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> putAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@RequestBody Animal animal) {
        animalService.deleteAnimal(animal);
    }
}
