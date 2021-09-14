package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Channel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface ChannelService {

    List<Channel> getAll();

    Channel get(UUID id) throws NoSuchElementException;

    void save(Channel channel);

    void delete(Channel channel) throws NoSuchElementException;
}
