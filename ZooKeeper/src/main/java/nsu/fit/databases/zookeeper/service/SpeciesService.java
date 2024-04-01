package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.Species;

import java.util.List;
import java.util.Optional;

public interface SpeciesService {

    List<Species> getAllSpecies();

    Optional<Species> getSpeciesById(Long speciesId);

    Species addSpecies(Species species);

    Optional<Species> updateSpeciesById(Long speciesId, Species species);

    void deleteSpeciesById(Long speciesId);
}
