package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Channel;
import pl.frackiewicz.vtuberapi.service.ChannelService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    private ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("")
    public List<Channel> getList() {
        return channelService.getAll();
    }

    @PostMapping("")
    public void addChannel(@RequestBody Channel channel) {
        channelService.save(channel);
    }

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable UUID id) {
        try {
            return channelService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeChannel(@PathVariable UUID id) {
        try {
            channelService.delete(channelService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateChannel(@RequestBody Channel channel) {
        channelService.save(channel);
    }
}
