package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Channel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChannelService {

    List<Channel> getAll();

    Optional<Channel> get(UUID id);

    void save(Channel channel);
}
