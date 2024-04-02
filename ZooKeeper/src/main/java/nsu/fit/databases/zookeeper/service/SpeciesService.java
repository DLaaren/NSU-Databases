package nsu.fit.databases.zookeeper.service;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Species;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.SpeciesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SpeciesService {

    private SpeciesRepository speciesRepository;

    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    public Species getSpeciesByIdOrThrow(Long id) {
        return speciesRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "Species with id " + id + " does not exist")
        );
    }

    public void nonExistOrThrow(Species species) {
        speciesRepository.findById(species.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                    "Species with id " + usr.getId() + " already exists");
        });
    }

    public Species getSpeciesById(Long id) {
        return getSpeciesByIdOrThrow(id);
    }

    public Species addSpecies(Species species) {
        nonExistOrThrow(species);
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Long id, Species species) {
        nonExistOrThrow(species);
        return speciesRepository.save(species);
    }

    public void deleteSpeciesById(Long id) {
        speciesRepository.deleteById(id);
    }
}
