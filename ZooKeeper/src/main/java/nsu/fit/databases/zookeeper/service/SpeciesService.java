package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    public Optional<Species> getSpeciesById(Long speciesId) {
        return speciesRepository.findById(speciesId);
    }

    public Species addSpecies(Species species) {
        speciesRepository.save(species);
        return species;
    }

    public Optional<Species> updateSpeciesById(Long speciesId, Species species) {
        if (!speciesRepository.findById(speciesId).isPresent()) {
            return Optional.empty();
        }
        speciesRepository.save(species);
        return Optional.of(species);
    }

    public void deleteSpeciesById(Long speciesId) {
        speciesRepository.deleteById(speciesId);
    }
}
