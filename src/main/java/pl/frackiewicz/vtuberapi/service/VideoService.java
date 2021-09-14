package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Video;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface VideoService {
    List<Video> getAll();

    Video get(UUID id) throws NoSuchElementException;

    void save(Video video);

    void delete(Video video) throws NoSuchElementException;
}
