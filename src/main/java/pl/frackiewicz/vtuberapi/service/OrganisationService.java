package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Organisation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationService {
    List<Organisation> getAll();

    Optional<Organisation> get(UUID id);

    void save(Organisation organisation);

    void delete(Organisation organisation);
}
