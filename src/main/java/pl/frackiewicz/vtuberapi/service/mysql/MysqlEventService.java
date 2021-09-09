package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Event;
import pl.frackiewicz.vtuberapi.repository.EventRepository;
import pl.frackiewicz.vtuberapi.service.EventService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlEventService implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public MysqlEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> get(UUID id) {
        return eventRepository.findById(id);
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }
}
