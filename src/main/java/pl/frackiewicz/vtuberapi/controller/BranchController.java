package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.service.BranchService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/branches")
public class BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("")
    public List<Branch> getList() {
        return branchService.getAll();
    }

    @PostMapping("")
    public void addBranch(@RequestBody Branch branch) {
        branchService.save(branch);
    }

    @GetMapping("/{id}")
    public Branch getBranch(@PathVariable UUID id) {
        try {
            return branchService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeBranch(@PathVariable UUID id) {
        try {
            branchService.delete(branchService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateBranch(@RequestBody Branch branch) {
        branchService.save(branch);
    }
}
