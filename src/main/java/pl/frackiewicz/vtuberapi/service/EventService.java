package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {

    List<Event> getAll();

    Optional<Event> get(UUID id);

    void save(Event event);
}
