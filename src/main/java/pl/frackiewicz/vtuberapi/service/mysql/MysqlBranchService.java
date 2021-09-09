package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.BranchRepository;
import pl.frackiewicz.vtuberapi.service.BranchService;

@Component
public class MysqlBranchService implements BranchService {
    private BranchRepository branchRepository;

    @Autowired
    public MysqlBranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
}
