package pl.frackiewicz.vtuberapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.Video;
import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<Video, UUID> {
}
