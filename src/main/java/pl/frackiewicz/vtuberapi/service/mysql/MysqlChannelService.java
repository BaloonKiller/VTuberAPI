package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Channel;
import pl.frackiewicz.vtuberapi.repository.ChannelRepository;
import pl.frackiewicz.vtuberapi.service.ChannelService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Component
public class MysqlChannelService implements ChannelService {
    private final ChannelRepository channelRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlChannelService.class);

    @Autowired
    public MysqlChannelService(ChannelRepository channelRepository, javax.validation.Validator validator) {
        this.channelRepository = channelRepository;
        this.validator = validator;
    }

    @Override
    public List<Channel> getAll() {
        return channelRepository.findAll();
    }

    @Override
    public Channel get(UUID id) throws NoSuchElementException {
        return channelRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Channel channel) {
        Set<ConstraintViolation<Channel>> violations = validator.validate(channel);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Channel> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            channelRepository.save(channel);
        }
    }

    @Override
    public void delete(Channel channel) throws NoSuchElementException {
        channelRepository.delete(channel);
    }
}
