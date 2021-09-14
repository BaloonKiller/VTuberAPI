package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Generation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface GenerationService {

    List<Generation> getAll();

    Generation get(UUID id) throws NoSuchElementException;

    void save(Generation generation);

    void delete(Generation generation) throws NoSuchElementException;
}
