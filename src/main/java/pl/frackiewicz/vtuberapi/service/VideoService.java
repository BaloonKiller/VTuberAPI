package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAll();
}
