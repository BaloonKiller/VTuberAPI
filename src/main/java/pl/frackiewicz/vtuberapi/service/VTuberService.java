package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VTuberService {
    List<VTuber> getAll();

    Optional<VTuber> get(UUID id);

    void save(VTuber vTuber);

    void delete(VTuber vTuber);
}
