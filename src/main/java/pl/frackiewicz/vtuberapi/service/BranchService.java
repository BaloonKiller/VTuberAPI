package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Branch;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface BranchService {
    List<Branch> getAll();

    Branch get(UUID uuid) throws NoSuchElementException;

    void save(Branch branch);

    void delete(Branch branch) throws NoSuchElementException;
}
