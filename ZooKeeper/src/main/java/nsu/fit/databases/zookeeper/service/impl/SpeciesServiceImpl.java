package nsu.fit.databases.zookeeper.service.impl;

import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import nsu.fit.databases.zookeeper.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Override
    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    @Override
    public Optional<Species> getSpeciesById(Long speciesId) {
        return speciesRepository.findById(speciesId);
    }

    @Override
    public Species addSpecies(Species species) {
        speciesRepository.save(species);
        return species;
    }

    @Override
    public Optional<Species> updateSpeciesById(Long speciesId, Species species) {
        if (!speciesRepository.findById(speciesId).isPresent()) {
            return Optional.empty();
        }
        speciesRepository.save(species);
        return Optional.of(species);
    }

    @Override
    public void deleteSpeciesById(Long speciesId) {
        speciesRepository.deleteById(speciesId);
    }
}
