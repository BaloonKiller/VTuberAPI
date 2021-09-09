package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Video;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VideoService {
    List<Video> getAll();

    Optional<Video> get(UUID id);

    void save(Video video);
}
