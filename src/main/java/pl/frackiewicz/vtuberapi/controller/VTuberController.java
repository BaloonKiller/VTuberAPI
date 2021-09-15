package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.VTuber;
import pl.frackiewicz.vtuberapi.service.VTuberService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/vtubers")
public class VTuberController {
    private VTuberService vTuberService;

    public VTuberController(VTuberService vTuberService) {
        this.vTuberService = vTuberService;
    }

    @GetMapping("")
    public List<VTuber> getAllVTubers() {
        return vTuberService.getAll();
    }

    @PostMapping("")
    public void addVTuber(@RequestBody VTuber vTuber) {
        vTuberService.save(vTuber);
    }

    @GetMapping("/{id}")
    public VTuber getVTuber(@PathVariable UUID id) {
        try {
            return vTuberService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeVTuber(@PathVariable UUID id) {
        try {
            vTuberService.delete(vTuberService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateVTuber(@RequestBody VTuber vTuber) {
        vTuberService.save(vTuber);
    }
}
