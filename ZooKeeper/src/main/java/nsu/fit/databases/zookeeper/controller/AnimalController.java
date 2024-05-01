package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.AnimalDto;
import nsu.fit.databases.zookeeper.entity.Animal;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.AnimalRepository;
import nsu.fit.databases.zookeeper.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController {

    private AnimalService animalService;
    private ModelMapper animalMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<AnimalDto> getAnimals() {
        return animalService.getAllAnimals().stream().map(this::convertToDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AnimalDto getAnimal(@PathVariable("id") Long id) {
        return convertToDto(animalService.getAnimalById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AnimalDto addAnimal(@RequestBody AnimalDto animalDto) {
        return convertToDto(animalService.addAnimal(convertToEntity(animalDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AnimalDto updateAnimal(@PathVariable("id") Long id,
                                  @RequestBody AnimalDto animalDto) {
        if (!Objects.equals(id, animalDto.getId()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertToDto(animalService.updateAnimal(convertToEntity(animalDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
    }

    private AnimalDto convertToDto(Animal animal) {
        String speciesName = animalService.getAnimalSpeciesName(animal);
        AnimalDto animalDto = animalMapper.map(animal, AnimalDto.class);
        animalDto.setSpeciesName(speciesName);
        return animalDto;
    }

    private Animal convertToEntity(AnimalDto animalDto) {
        Animal animal = animalMapper.map(animalDto, Animal.class);
        animal.setSpecies(animalService.getAnimalSpeciesId(animal));
        return animal;
    }
}
