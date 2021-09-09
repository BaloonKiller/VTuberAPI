package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.OrganisationRepository;
import pl.frackiewicz.vtuberapi.service.OrganisationService;

@Component
public class MysqlOrganisationService implements OrganisationService {
    private OrganisationRepository organisationRepository;

    @Autowired
    public MysqlOrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }
}
