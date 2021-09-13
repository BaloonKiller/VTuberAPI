package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Video;
import pl.frackiewicz.vtuberapi.repository.VideoRepository;
import pl.frackiewicz.vtuberapi.service.VideoService;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlVideoService implements VideoService {
    private VideoRepository videoRepository;
    private Validator validator;

    @Autowired
    public MysqlVideoService(VideoRepository videoRepository, Validator validator) {
        this.videoRepository = videoRepository;
        this.validator = validator;
    }

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> get(UUID id) {
        return videoRepository.findById(id);
    }

    @Override
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void delete(Video video) {
        videoRepository.delete(video);
    }
}
