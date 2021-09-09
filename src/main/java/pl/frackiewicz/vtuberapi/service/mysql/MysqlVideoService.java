package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Video;
import pl.frackiewicz.vtuberapi.repository.VideoRepository;
import pl.frackiewicz.vtuberapi.service.VideoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlVideoService implements VideoService {
    private VideoRepository videoRepository;

    @Autowired
    public MysqlVideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> get(UUID id) {
        return videoRepository.findById(id);
    }
}
