package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.ChannelRepository;
import pl.frackiewicz.vtuberapi.service.ChannelService;

@Component
public class MysqlChannelService implements ChannelService {
    private ChannelRepository channelRepository;

    @Autowired
    public MysqlChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }
}
