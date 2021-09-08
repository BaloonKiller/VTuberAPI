package pl.frackiewicz.vtuberapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.Generation;
import java.util.UUID;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, UUID> {
}
