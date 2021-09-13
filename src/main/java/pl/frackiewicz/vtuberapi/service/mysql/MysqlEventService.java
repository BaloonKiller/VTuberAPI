package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.entity.Event;
import pl.frackiewicz.vtuberapi.repository.EventRepository;
import pl.frackiewicz.vtuberapi.service.EventService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlEventService implements EventService {
    private EventRepository eventRepository;
    private Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlEventService.class);

    @Autowired
    public MysqlEventService(EventRepository eventRepository, Validator validator) {
        this.eventRepository = eventRepository;
        this.validator = validator;
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
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Event> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            eventRepository.save(event);
        }
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }
}
