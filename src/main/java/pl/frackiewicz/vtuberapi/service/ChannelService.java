package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Channel;

import java.util.List;

public interface ChannelService {

    List<Channel> getAll();
}
