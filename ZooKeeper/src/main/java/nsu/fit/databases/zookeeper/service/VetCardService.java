package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.entity.VetCard;

import java.util.List;
import java.util.Optional;

public interface VetCardService {

    List<VetCard> getAllVetCards();

    Optional<VetCard> getVetCardById(Long vetCardId);

    VetCard addVetCard(VetCard vetCard);

    Optional<VetCard> updateVetCardById(Long vetCardId, VetCard vetCard);

    void deleteVetCardById(Long vetCardId);
}
