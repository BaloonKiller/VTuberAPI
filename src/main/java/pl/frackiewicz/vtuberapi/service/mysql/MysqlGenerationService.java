package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Generation;
import pl.frackiewicz.vtuberapi.repository.GenerationRepository;
import pl.frackiewicz.vtuberapi.service.GenerationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlGenerationService implements GenerationService {
    private final GenerationRepository generationRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlGenerationService.class);

    @Autowired
    public MysqlGenerationService(GenerationRepository generationRepository, Validator validator) {
        this.generationRepository = generationRepository;
        this.validator = validator;
    }

    @Override
    public List<Generation> getAll() {
        return generationRepository.findAll();
    }

    @Override
    public Generation get(UUID id) throws NoSuchElementException {
        return generationRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Generation generation) {
        Set<ConstraintViolation<Generation>> violations = validator.validate(generation);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Generation> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            generationRepository.save(generation);
        }
    }

    @Override
    public void delete(Generation generation) {
        generationRepository.delete(generation);
    }
}
