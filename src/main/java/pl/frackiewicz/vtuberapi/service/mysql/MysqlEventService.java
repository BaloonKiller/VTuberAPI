package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.EventRepository;
import pl.frackiewicz.vtuberapi.service.EventService;

@Component
public class MysqlEventService implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public MysqlEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
