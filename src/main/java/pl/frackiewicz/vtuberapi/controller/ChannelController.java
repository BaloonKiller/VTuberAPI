package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    private ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }
}
