package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public ResponseEntity<List<Species>> getSpecies() {
        List<Species> species = speciesService.getAllSpecies();
        if (species.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(species);
    }

    @GetMapping("{id}")
    public ResponseEntity<Species> getSpecies(@PathVariable("id") Long speciesId) {
        Optional<Species> species = speciesService.getSpeciesById(speciesId);
        if (!species.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(species.get());
    }

    @PostMapping
    public ResponseEntity<Species> addSpecies(@RequestBody Species species) {
        Species registeredSpecies = speciesService.addSpecies(species);
        return new ResponseEntity<>(registeredSpecies, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Species> updateSpecies(@PathVariable("id") Long speciesId,
                                                 @RequestBody Species species) {
        Optional<Species> _species = speciesService.updateSpeciesById(speciesId, species);
        if (!_species.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(_species.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSpecies(@PathVariable("id") Long speciesId) {
        speciesService.deleteSpeciesById(speciesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
