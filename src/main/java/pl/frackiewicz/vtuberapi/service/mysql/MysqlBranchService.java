package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.repository.BranchRepository;
import pl.frackiewicz.vtuberapi.service.BranchService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;


@Component
public class MysqlBranchService implements BranchService {
    private final Validator validator;
    private final BranchRepository branchRepository;
    private static final Logger logger = LogManager.getLogger(MysqlBranchService.class);

    @Autowired
    public MysqlBranchService(BranchRepository branchRepository, Validator validator) {
        this.branchRepository = branchRepository;
        this.validator = validator;
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch get(UUID id) throws NoSuchElementException {
        return branchRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Branch branch) {
        Set<ConstraintViolation<Branch>> violations = validator.validate(branch);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Branch> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            branchRepository.save(branch);
        }
    }

    @Override
    public void delete(Branch branch) throws NoSuchElementException{
        get(branch.getId());
        branchRepository.delete(branch);
    }
}
