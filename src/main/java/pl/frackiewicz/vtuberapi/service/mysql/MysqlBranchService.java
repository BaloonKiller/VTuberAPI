package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.repository.BranchRepository;
import pl.frackiewicz.vtuberapi.service.BranchService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlBranchService implements BranchService {
    private BranchRepository branchRepository;

    @Autowired
    public MysqlBranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> get(UUID id) {
        return branchRepository.findById(id);
    }
}
