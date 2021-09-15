package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Generation;
import pl.frackiewicz.vtuberapi.service.GenerationService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/generations")
public class GenerationController {
    private GenerationService generationService;

    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }

    @GetMapping("")
    public List<Generation> getList() {
        return generationService.getAll();
    }

    @PostMapping("")
    public void addGeneration(@RequestBody Generation generation) {
        generationService.save(generation);
    }

    @GetMapping("/{id}")
    public Generation getGeneration(@PathVariable UUID id) {
        try {
            return generationService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeGeneration(@PathVariable UUID id) {
        try {
            generationService.delete(generationService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateGeneration(@RequestBody Generation generation) {
        generationService.save(generation);
    }
}
