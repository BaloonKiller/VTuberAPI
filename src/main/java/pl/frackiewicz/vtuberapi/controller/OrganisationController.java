package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Organisation;
import pl.frackiewicz.vtuberapi.service.OrganisationService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {
    public OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("")
    public List<Organisation> getList() {
        return organisationService.getAll();
    }

    @PostMapping("")
    public void addOrganisation(@RequestBody Organisation organisation) {
        organisationService.save(organisation);
    }

    @GetMapping("/{id}")
    public Organisation getOrganisation(@PathVariable UUID id) {
        try {
            return organisationService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @DeleteMapping("/{id}")
    public void removeOrganisation(@PathVariable String id) {
        try {
            Organisation organisationToDelete = organisationService.get(UUID.fromString(id));
            organisationService.delete(organisationToDelete);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @PutMapping("")
    public void updateOrganisation(@RequestBody Organisation organisation) {
        organisationService.save(organisation);
    }
}
