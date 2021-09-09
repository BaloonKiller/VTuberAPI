package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Channel;
import pl.frackiewicz.vtuberapi.repository.ChannelRepository;
import pl.frackiewicz.vtuberapi.service.ChannelService;

import java.util.List;

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
}
