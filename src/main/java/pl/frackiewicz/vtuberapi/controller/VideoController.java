package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {
    private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
}
