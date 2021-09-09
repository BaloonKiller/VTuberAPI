package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> getAll();
}
