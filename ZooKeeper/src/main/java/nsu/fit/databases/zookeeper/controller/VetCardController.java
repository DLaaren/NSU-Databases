package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.service.VetCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@RestController
@RequestMapping("/vetcards")
public class VetCardController {

    @Autowired
    private VetCardService vetCardService;

    @GetMapping
    public ResponseEntity<List<VetCard>> getVetCards() {
        List<VetCard> vetCards = vetCardService.getAllVetCards();
        if (vetCards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(vetCards);
    }

    @GetMapping("{id}")
    public ResponseEntity<VetCard> getAnimal(@PathVariable("id") Long vetCardId) {
        Optional<VetCard> animal = vetCardService.getVetCardById(vetCardId);
        if (!animal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(animal.get());
    }

    @PostMapping
    public ResponseEntity<VetCard> addAnimal(@RequestBody VetCard animal) {
        VetCard registeredAnimal = vetCardService.addVetCard(animal);
        return new ResponseEntity<>(registeredAnimal, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<VetCard> updateAnimal(@PathVariable("id") Long vetCardId,
                                               @RequestBody VetCard animal) {
        Optional<VetCard> _animal = vetCardService.updateVetCardById(vetCardId, animal);
        if (!_animal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(_animal.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("id") Long vetCardId) {
        vetCardService.deleteVetCardById(vetCardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
