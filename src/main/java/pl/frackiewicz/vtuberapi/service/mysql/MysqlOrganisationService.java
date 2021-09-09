package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Organisation;
import pl.frackiewicz.vtuberapi.repository.OrganisationRepository;
import pl.frackiewicz.vtuberapi.service.OrganisationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlOrganisationService implements OrganisationService {
    private OrganisationRepository organisationRepository;

    @Autowired
    public MysqlOrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public List<Organisation> getAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Optional<Organisation> get(UUID id) {
        return organisationRepository.findById(id);
    }

    @Override
    public void save(Organisation organisation) {
        organisationRepository.save(organisation);
    }

    @Override
    public void delete(Organisation organisation) {
        organisationRepository.delete(organisation);
    }
}
