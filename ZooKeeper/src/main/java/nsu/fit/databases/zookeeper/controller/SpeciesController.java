package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.SpeciesDto;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.service.SpeciesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/species")
public class SpeciesController {

    private SpeciesService speciesService;
    private ModelMapper speciesMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<SpeciesDto> getSpecies() {
        return speciesService.getAllSpecies().stream().map(this::convertToDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SpeciesDto getSpecies(@PathVariable("id") Long id) {
        return convertToDto(speciesService.getSpeciesById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SpeciesDto addSpecies(@RequestBody SpeciesDto speciesDto) {
        return convertToDto(speciesService.addSpecies(convertToEntity(speciesDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpeciesDto updateSpecies(@PathVariable("id") Long id,
                                  @RequestBody SpeciesDto speciesDto) {
        if (!Objects.equals(id, speciesDto.id()))
        {
            throw new ServerException(HttpStatus.BAD_REQUEST, "IDs don't match");
        }
        return convertToDto(speciesService.updateSpecies(id, convertToEntity(speciesDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpecies(@PathVariable("id") Long id) {
        speciesService.deleteSpeciesById(id);
    }

    private SpeciesDto convertToDto(Species species) {
        return speciesMapper.map(species, SpeciesDto.class);
    }

    private Species convertToEntity(SpeciesDto speciesDto) {
        return speciesMapper.map(speciesDto, Species.class);
    }
}
