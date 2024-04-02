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
    public ResponseEntity<VetCard> getVetCard(@PathVariable("id") Long vetCardId) {
        Optional<VetCard> vetCard = vetCardService.getVetCardById(vetCardId);
        if (!vetCard.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(vetCard.get());
    }

    @PostMapping
    public ResponseEntity<VetCard> addVetCard(@RequestBody VetCard vetCard) {
        VetCard registeredVetCard = vetCardService.addVetCard(vetCard);
        return new ResponseEntity<>(registeredVetCard, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<VetCard> updateVetCard(@PathVariable("id") Long vetCardId,
                                               @RequestBody VetCard vetCard) {
        Optional<VetCard> _vetCard = vetCardService.updateVetCardById(vetCardId, vetCard);
        if (!_vetCard.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(_vetCard.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteVetCard(@PathVariable("id") Long vetCardId) {
        vetCardService.deleteVetCardById(vetCardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
