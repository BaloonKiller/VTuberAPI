package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Organisation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface OrganisationService {
    List<Organisation> getAll();

    Organisation get(UUID id) throws NoSuchElementException;

    void save(Organisation organisation);


    void delete(Organisation organisation) throws NoSuchElementException;
}
