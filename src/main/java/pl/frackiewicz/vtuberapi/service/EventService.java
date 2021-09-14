package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Event;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface EventService {

    List<Event> getAll();

    Event get(UUID id) throws NoSuchElementException;

    void save(Event event);

    void delete(Event event) throws NoSuchElementException;
}
