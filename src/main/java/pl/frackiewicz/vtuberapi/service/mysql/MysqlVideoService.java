package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Video;
import pl.frackiewicz.vtuberapi.repository.VideoRepository;
import pl.frackiewicz.vtuberapi.service.VideoService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlVideoService implements VideoService {
    private final VideoRepository videoRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlVideoService.class);

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
    public Video get(UUID id) throws NoSuchElementException {
        return videoRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Video video) {
        Set<ConstraintViolation<Video>> violations = validator.validate(video);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Video> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            videoRepository.save(video);
        }
    }

    @Override
    public void delete(Video video) throws NoSuchElementException {
        videoRepository.delete(video);
    }
}
