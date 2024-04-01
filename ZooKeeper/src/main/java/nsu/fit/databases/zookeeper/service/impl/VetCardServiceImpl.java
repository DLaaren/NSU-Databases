package nsu.fit.databases.zookeeper.service.impl;

import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.repository.VetCardRepository;
import nsu.fit.databases.zookeeper.service.VetCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetCardServiceImpl implements VetCardService {

    @Autowired
    private VetCardRepository vetCardRepository;

    @Override
    public List<VetCard> getAllVetCards() {
        return vetCardRepository.findAll();
    }

    @Override
    public Optional<VetCard> getVetCardById(Long vetCardId) {
        return vetCardRepository.findById(vetCardId);
    }

    @Override
    public VetCard addVetCard(VetCard vetCard) {
        vetCardRepository.save(vetCard);
        return vetCard;
    }

    @Override
    public Optional<VetCard> updateVetCardById(Long vetCardId, VetCard vetCard) {
        if (!vetCardRepository.findById(vetCardId).isPresent()) {
            return Optional.empty();
        }
        vetCardRepository.save(vetCard);
        return Optional.of(vetCard);
    }

    @Override
    public void deleteVetCardById(Long vetCardId) {
        vetCardRepository.deleteById(vetCardId);
    }
}
