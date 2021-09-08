package pl.frackiewicz.vtuberapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.Event;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
