package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Channel;
import pl.frackiewicz.vtuberapi.repository.ChannelRepository;
import pl.frackiewicz.vtuberapi.service.ChannelService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlChannelService implements ChannelService {
    private ChannelRepository channelRepository;

    @Autowired
    public MysqlChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public List<Channel> getAll() {
        return channelRepository.findAll();
    }

    @Override
    public Optional<Channel> get(UUID id) {
        return channelRepository.findById(id);
    }

    @Override
    public void save(Channel channel) {
        channelRepository.save(channel);
    }

    @Override
    public void delete(Channel channel) {
        channelRepository.delete(channel);
    }
}
