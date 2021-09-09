package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Generation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenerationService {

    List<Generation> getAll();

    Optional<Generation> get(UUID id);

    void save(Generation generation);

    void delete(Generation generation);
}
