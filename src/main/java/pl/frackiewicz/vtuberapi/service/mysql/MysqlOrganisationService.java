package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Organisation;
import pl.frackiewicz.vtuberapi.repository.OrganisationRepository;
import pl.frackiewicz.vtuberapi.service.OrganisationService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlOrganisationService implements OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlOrganisationService.class);

    @Autowired
    public MysqlOrganisationService(OrganisationRepository organisationRepository, Validator validator) {
        this.organisationRepository = organisationRepository;
        this.validator = validator;
    }

    @Override
    public List<Organisation> getAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation get(UUID id) throws NoSuchElementException {
        return organisationRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Organisation organisation) {
        Set<ConstraintViolation<Organisation>> violations = validator.validate(organisation);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Organisation> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            organisationRepository.save(organisation);
        }
    }

    @Override
    public void delete(Organisation organisation) {
        organisationRepository.delete(organisation);
    }
}
