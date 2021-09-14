package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.VTuber;
import pl.frackiewicz.vtuberapi.repository.VTuberRepository;
import pl.frackiewicz.vtuberapi.service.VTuberService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlVTuberService implements VTuberService {
    private final VTuberRepository vTuberRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlVTuberService.class);

    @Autowired
    public MysqlVTuberService(VTuberRepository vTuberRepository, Validator validator) {
        this.vTuberRepository = vTuberRepository;
        this.validator = validator;
    }

    @Override
    public List<VTuber> getAll() {
        return vTuberRepository.findAll();
    }

    @Override
    public VTuber get(UUID id) throws NoSuchElementException {
        return vTuberRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(VTuber vTuber) {
        Set<ConstraintViolation<VTuber>> violations = validator.validate(vTuber);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<VTuber> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            vTuberRepository.save(vTuber);
        }
    }

    @Override
    public void delete(VTuber vTuber) {
        vTuberRepository.delete(vTuber);
    }
}
