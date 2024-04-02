package nsu.fit.databases.zookeeper.service;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.VetCard;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.VetCardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VetCardService {

    private VetCardRepository vetCardRepository;

    public List<VetCard> getAllVetCards() {
        return vetCardRepository.findAll();
    }

    public VetCard getVetCardByIdOrThrow(Long id) {
        return vetCardRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "VetCard with id " + id + " does not exist")
        );
    }

    public void nonExistOrThrow(VetCard vetCard) {
        vetCardRepository.findById(vetCard.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "VetCard with id " + usr.getId() + " already exists");
        });
    }

    public VetCard getVetCardById(Long id) {
        return getVetCardByIdOrThrow(id);
    }

    public VetCard addVetCard(VetCard vetCard) {
        nonExistOrThrow(vetCard);
        return vetCardRepository.save(vetCard);
    }

    public VetCard updateVetCard(Long id, VetCard vetCard) {
        nonExistOrThrow(vetCard);
        return vetCardRepository.save(vetCard);
    }

    public void deleteVetCardById(Long id) {
        vetCardRepository.deleteById(id);
    }
}
