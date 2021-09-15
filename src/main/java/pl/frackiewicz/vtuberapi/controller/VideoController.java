package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Video;
import pl.frackiewicz.vtuberapi.service.VideoService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/videos")
public class VideoController {
    private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("")
    public List<Video> getList() {
        return videoService.getAll();
    }

    @PostMapping("")
    public void addVideo(@RequestBody Video video) {
        videoService.save(video);
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable UUID id) {
        try {
            return videoService.get(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{id}")
    public void removeVideo(@PathVariable UUID id) {
        try {
            videoService.delete(videoService.get(id));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateVideo(@RequestBody Video video) {
        videoService.save(video);
    }
}
