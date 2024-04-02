package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.repository.VetCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetCardService {

    @Autowired
    private VetCardRepository vetCardRepository;

    public List<VetCard> getAllVetCards() {
        return vetCardRepository.findAll();
    }

    public Optional<VetCard> getVetCardById(Long vetCardId) {
        return vetCardRepository.findById(vetCardId);
    }

    public VetCard addVetCard(VetCard vetCard) {
        vetCardRepository.save(vetCard);
        return vetCard;
    }

    public Optional<VetCard> updateVetCardById(Long vetCardId, VetCard vetCard) {
        if (!vetCardRepository.findById(vetCardId).isPresent()) {
            return Optional.empty();
        }
        vetCardRepository.save(vetCard);
        return Optional.of(vetCard);
    }

    public void deleteVetCardById(Long vetCardId) {
        vetCardRepository.deleteById(vetCardId);
    }
}
