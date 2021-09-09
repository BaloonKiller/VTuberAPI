package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Branch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BranchService {
    List<Branch> getAll();

    Optional<Branch> get(UUID uuid);

    void save(Branch branch);
}
