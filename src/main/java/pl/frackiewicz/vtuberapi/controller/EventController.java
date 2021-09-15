package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Event;
import pl.frackiewicz.vtuberapi.service.EventService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public List<Event> getList() {
        return eventService.getAll();
    }

    @PostMapping("")
    public void addEvent(@RequestBody Event event) {
        eventService.save(event);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable UUID id) {
        try {
            return eventService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeEvent(@PathVariable UUID id) {
        try {
            eventService.delete(eventService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateEvent(@RequestBody Event event) {
        eventService.save(event);
    }
}
