package pl.frackiewicz.vtuberapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.Organisation;
import java.util.UUID;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {
}
