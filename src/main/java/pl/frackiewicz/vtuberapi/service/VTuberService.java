package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface VTuberService {
    List<VTuber> getAll();

    VTuber get(UUID id) throws NoSuchElementException;

    void save(VTuber vTuber);

    void delete(VTuber vTuber) throws NoSuchElementException;
}
